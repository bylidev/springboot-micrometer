package cl.tenpo.microservice.a;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@Slf4j
@AllArgsConstructor
public class Controller {

  private RestClient restClient;

  private KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping("/a")
  public void hello() {
    log.info("Hello from microservice A");

    restClient
        .get()
        .uri("http://localhost:8088/b")
        .retrieve();

    this.kafkaTemplate.send("topic", "Hello from microservice A");

  }

}
