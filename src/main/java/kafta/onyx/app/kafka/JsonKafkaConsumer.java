package kafta.onyx.app.kafka;

import kafta.onyx.app.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic-json.name}")
    public void consume(User user) {
        log.info(String.format("Json Message received -> %s", user.toString()));
    }
}
