package br.com.cadastrodepessoa.controller;

import br.com.cadastrodepessoa.dto.EmailDto;
import br.com.cadastrodepessoa.entity.EmailModel;
import br.com.cadastrodepessoa.service.impl.EmailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailServiceImpl emailService;



    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendEmail (@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto,emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }


}
