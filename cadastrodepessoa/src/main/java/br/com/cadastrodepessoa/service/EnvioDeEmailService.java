package br.com.cadastrodepessoa.service;

import br.com.cadastrodepessoa.entity.EmailModel;

public interface EnvioDeEmailService {

    EmailModel sendEmail(EmailModel emailModel);
}
