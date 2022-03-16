package org.example.embedded.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmbeddedKafkaExample {
    public static void main(String args[]) {
        SpringApplication.run(EmbeddedKafkaExample.class, args);
        System.out.println("Hello. . . . . !!!");
    }
}
