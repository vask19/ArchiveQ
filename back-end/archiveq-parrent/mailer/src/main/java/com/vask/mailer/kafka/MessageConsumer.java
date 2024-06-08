package com.vask.mailer.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vask.mailer.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final String topicName = "mailer";

    private final EmailService emailService;

    @KafkaListener(topics = topicName, groupId = "my-group-id")
    public void listen(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        EmailReceiver instance = mapper.readValue(message, EmailReceiver.class);
        log.info("Message: {}", instance);
        emailService.sendMail(instance);
    }

}
