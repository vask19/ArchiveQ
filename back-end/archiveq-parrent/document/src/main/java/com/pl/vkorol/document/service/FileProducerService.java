package com.pl.vkorol.document.service;

import com.pl.vkorol.document.kafka.FtpFileMessage;
import com.pl.vkorol.document.kafka.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileProducerService {

    private final MessageProducer messageProducer;

    @Value("${kafka.ftp-topic}")
    private String topic;

    public void sendFile(FtpFileMessage ftpFileMessage) {
        messageProducer.publish(topic, ftpFileMessage);
    }
}
