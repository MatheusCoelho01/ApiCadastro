package br.com.cadastrodepessoa.service.impl;

import br.com.cadastrodepessoa.entity.EmailModel;
import br.com.cadastrodepessoa.repository.EmailRepository;
import br.com.cadastrodepessoa.service.EnvioDeEmailService;
import br.com.cadastrodepessoa.typeEnum.StatusEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements EnvioDeEmailService {


    @Autowired
    EmailRepository repository;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public EmailModel sendEmail(EmailModel emailModel) {

        emailModel.setSendDataEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            mailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException ignored) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        return repository.save(emailModel);
    }
}
