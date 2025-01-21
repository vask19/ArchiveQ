package com.pl.vkorol.document.service;

import com.pl.vkorol.document.kafka.DocumentMessage;
import com.pl.vkorol.document.kafka.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentProducerService {
    private final MessageProducer messageProducer;

    @Value("${kafka.document-topic}")
    private String topic;

    public void sendFile(DocumentMessage ftpFileMessage) {
        messageProducer.publish(topic, ftpFileMessage);
    }
}
