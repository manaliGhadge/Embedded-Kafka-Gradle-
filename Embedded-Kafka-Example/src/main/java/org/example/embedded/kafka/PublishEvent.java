package org.example.embedded.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PublishEvent{

    @Autowired
    KafkaTemplate<String, String> template;

    void publishEvent() {
        Random random = new Random();
        template.send("Kafka.Event", random.toString(), "Testing kafka...!!!");
    }
}
