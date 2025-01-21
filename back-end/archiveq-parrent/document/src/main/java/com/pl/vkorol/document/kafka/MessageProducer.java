package com.pl.vkorol.document.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void publish(String topic, KafkaMessage fileMessage) {
        var message = MessageBuilder
                .withPayload(fileMessage)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader("spring.json.type", fileMessage.getClass().getName())
                .build();
        kafkaTemplate.send(message);
    }
}
