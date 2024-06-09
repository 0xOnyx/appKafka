package kafta.onyx.app.controller;

import kafta.onyx.app.kafka.JsonKafkaProducer;
import kafta.onyx.app.payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private final JsonKafkaProducer kafkaProducerService;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducerService.sendMessage(user);
        return ResponseEntity.ok("Message sent to the Kafka Topic Successfully");
    }
}
