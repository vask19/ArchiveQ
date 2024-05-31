package com.vask.mailer.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vask.mailer.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MessageConsumer {

    private final String topicName = "mailer";
    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = topicName, groupId = "my-group-id")
    public void listen(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        EmailReceiver instance = mapper.readValue(message, EmailReceiver.class);
        log.info("Message: {}", instance);
        emailService.sendEmailWithText(instance);
    }

}
