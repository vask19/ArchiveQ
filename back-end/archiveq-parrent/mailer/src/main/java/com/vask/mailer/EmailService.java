package com.vask.mailer;

import com.vask.mailer.kafka.EmailReceiver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;
    @Value(value = "${spring.mail.sender.email}")
    private  String senderEmail;

    public void sendEmailWithText(EmailReceiver emailReceiver) {
        var message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setSubject(emailReceiver.getSubject());
        message.setText(emailReceiver.getText());
        message.setTo(emailReceiver.getEmail());
        javaMailSender.send(message);
        log.info("Sent mail.");
    }
}
