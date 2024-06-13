package cl.tenpo.microservice.b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  @KafkaListener(topics = "topic", groupId = "microservice_b")
  public void consume(String message) {
    log.info("Microservice B consumed message: " + message);
  }

}
