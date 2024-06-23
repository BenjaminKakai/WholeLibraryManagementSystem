package com.gateway.apigateway.gateway;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "your_topic_name", groupId = "group_id")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        // Process the received message accordingly
    }
}
