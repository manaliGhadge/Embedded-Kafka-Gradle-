package org.example.embedded.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import java.util.Map;

import static org.springframework.kafka.test.utils.KafkaTestUtils.producerProps;

@EmbeddedKafka
@EnableKafka
@Configuration
public class EmbeddedKafkaConfig {

    @Bean
    EmbeddedKafkaBroker broker() {
        EmbeddedKafkaBroker broker = new EmbeddedKafkaBroker(1, true, "Kafka.Event");
        broker.brokerProperty("listeners", "PLAINTEXT://localhost:9092");
        return broker;
    }

    @Bean
    ProducerFactory producerFactory(EmbeddedKafkaBroker broker) {
        Map<String, Object> configMap = producerProps(broker);
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory(configMap);
        return producerFactory;
    }

    @Bean
    KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        KafkaTemplate kafkaTemplate = new KafkaTemplate(producerFactory);
        return kafkaTemplate;
    }
}
