package kafta.onyx.app.kafka;

import kafta.onyx.app.payload.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JsonKafkaProducer {
    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {

        log.info(String.format("Json Message sent -> %s", user));

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}
