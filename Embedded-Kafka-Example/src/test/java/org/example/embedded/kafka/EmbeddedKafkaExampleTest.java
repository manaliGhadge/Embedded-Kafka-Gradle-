package org.example.embedded.kafka;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EmbeddedKafkaExampleTest {
    @Autowired
    PublishEvent publish;

    @MockBean
    KafkaTemplate<String, String> template;
    @Test
    void contextLoads() {
    }

    @Test
    void testKafkaPublish() {
        publish.publishEvent();
        verify(template, times(1)).send(any(), any(), any());
    }
}
