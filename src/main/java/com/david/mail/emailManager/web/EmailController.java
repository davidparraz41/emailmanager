package com.david.mail.emailManager.web;

import com.david.mail.emailManager.dto.EmailDto;
import com.david.mail.emailManager.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rest/Email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    EmailService emailService;

    @PostMapping("Envio")
    public ResponseEntity<Void> enviarEmailResultadoProcesoCertificacion(@RequestBody EmailDto emailDto) {
        try {
            logger.info("Enviando el email a " + emailDto.getCorreo());
            emailService.enviarEmailResultadoProcesoCertificacion(emailDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Ha ocurrido un error, Detalle > " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
