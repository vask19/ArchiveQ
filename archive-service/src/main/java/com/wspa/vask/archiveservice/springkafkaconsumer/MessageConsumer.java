//package com.wspa.vask.archiveservice.springkafkaconsumer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class MessageConsumer {
//    private final String topicName = "dmstest";
//
//    @KafkaListener(topics = topicName, groupId = "my-group-id")
//    public void listen(String message) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        KafkaMessage instance = mapper.readValue(message, KafkaMessage.class);
//        System.out.println(instance);
//      //  System.out.println(message);
//
//    }
//
//}
