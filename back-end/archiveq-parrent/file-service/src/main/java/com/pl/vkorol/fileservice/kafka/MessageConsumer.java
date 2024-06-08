package com.pl.vkorol.fileservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pl.vkorol.fileservice.service.FtpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final String topicName = "ftp";
    private final FtpService ftpService;

    @KafkaListener(topics = topicName, groupId = "my-group-id")
    public void listen(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FtpFile instance = mapper.readValue(message, FtpFile.class);
        log.info("Message: {}", instance.getFileName());
        ftpService.uploadFileToFtp(instance);
    }

}
