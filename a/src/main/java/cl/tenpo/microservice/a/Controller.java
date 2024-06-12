package cl.tenpo.microservice.a;

import io.micrometer.tracing.SpanName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@Slf4j
public class Controller {

  @Autowired
  private RestClient restClient;

  @GetMapping("/a")
  @SpanName("flujo de hello")
  public void hello() {
    log.info("Hello from microservice A");
    restClient.get().uri("http://localhost:8088/b").retrieve();
  }

}
