package com.pl.vkorol.auth.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void sendMessage(String topic, KafkaMessage emailReceiver) {
        kafkaTemplate.send(topic, emailReceiver);
    }
}
