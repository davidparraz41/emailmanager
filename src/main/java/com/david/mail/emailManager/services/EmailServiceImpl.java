package com.david.mail.emailManager.services;

import com.david.mail.emailManager.EmailContent;
import com.david.mail.emailManager.EmailException;
import com.david.mail.emailManager.EmailManager;
import com.david.mail.emailManager.EmailProperties;
import com.david.mail.emailManager.dto.EmailDto;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {


    @Override
    public void enviarEmailResultadoProcesoCertificacion(EmailDto emailDto) throws EmailException, MessagingException, IOException {
        EmailContent emailContent = new EmailContent();
        emailContent.setContentHtml("Hola " + emailDto.getNombreReceptor() + " el estado final de su proceso de certificacion es: " + emailDto.getEstado());
        emailContent.setSubject("Antecedentes validados");
        String[] to = {emailDto.getCorreo()};
        emailContent.setTo(to);
        EmailProperties emailProperties = new EmailProperties();
        emailProperties.setEmailEmisor("david@piolet.cl");
        emailProperties.setContrasenaEmailEmisor("ul#wEzvaz{LM");
        emailProperties.setHost("mail.piolet.cl");
        emailProperties.setPort("26");
        emailProperties.setRequiereAutenticacion(false);
        EmailManager emailManager = EmailManager.setup(emailProperties);
        emailManager.sendEmail(emailContent);
    }


}
