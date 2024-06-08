package com.pl.vkorol.auth.service;

import com.pl.vkorol.auth.entity.User;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.pl.vkorol.auth.kafka.KafkaMessage;
import com.pl.vkorol.auth.kafka.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final MessageProducer messageProducer;

    @Value("${front.url}")
    private String fontendUrl;

    @Value("classpath:static/mail-aktywuj.html")
    private Resource activeTemplate;
    @Value("classpath:static/resetuj-haslo.html")
    private Resource recoveryTemplate;
    @Value("${kafka.mailler-topic}")
    private String mailerTopic;


    public void sendActivation(User user) {
        log.info("--START sendActivation");
        try {
            String html = Files.toString(activeTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com", fontendUrl + "/aktywuj/" + user.getUuid());
            KafkaMessage kafkaMessage = KafkaMessage.builder()
                    .email(user.getEmail())
                    .subject("Aktywacja konta")
                    .text(html)
                    .build();
            messageProducer.sendMessage(mailerTopic, kafkaMessage);
        } catch (IOException e) {
            log.info("Cant send mail");
            throw new RuntimeException(e);
        }
        log.info("--STOP sendActivation");
    }

    public void sendPasswordRecovery(User user, String uid) {
        try {
            log.info("--START sendPasswordRecovery");
            String html = Files.toString(recoveryTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com", fontendUrl + "/odzyskaj-haslo/" + uid);
            KafkaMessage kafkaMessage = KafkaMessage.builder()
                    .email(user.getEmail())
                    .subject("Aktywacja konta")
                    .text(html)
                    .build();
            messageProducer.sendMessage(mailerTopic, kafkaMessage);
        } catch (IOException e) {
            log.info("Cant send mail");
            throw new RuntimeException(e);
        }
        log.info("--STOP sendPasswordRecovery");
    }
}
