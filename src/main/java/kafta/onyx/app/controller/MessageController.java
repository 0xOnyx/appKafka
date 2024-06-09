package kafta.onyx.app.controller;

import kafta.onyx.app.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private final KafkaProducer kafkaProducerService;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(
            @RequestParam("message") String message){
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Kafka Topic java_in_use_topic Successfully");
    }
}
