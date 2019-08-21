package com.david.mail.emailManager.services;

import com.david.mail.emailManager.EmailException;
import com.david.mail.emailManager.dto.EmailDto;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void enviarEmailResultadoProcesoCertificacion(EmailDto emailDto) throws EmailException, MessagingException, IOException;
}
