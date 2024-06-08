package com.pl.vkorol.document.service;

import com.pl.vkorol.document.kafka.KafkaMessage;
import com.pl.vkorol.document.kafka.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private final MessageProducer messageProducer;

    @Value("${kafka.ftp-topic}")
    private String topic;

    public void sendFile(KafkaMessage kafkaMessage) {
        messageProducer.sendMessage(topic, kafkaMessage);
    }
}
