package cl.tenpo.microservice;

import io.micrometer.tracing.SpanName;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class Controller {
  private ClientService clientService;

  @GetMapping("/call-b")
  @SpanName("flujo de hello")
  public void hello() {
    log.info("calling B sync");
    clientService.getSyncB();
  }

  @GetMapping("/call-b-async")
  @SpanName("flujo de hello")
  public void helloAsync() {
    log.info("calling B async");
    clientService.getAsyncB();
  }

  @GetMapping("/b")
  @SpanName("flujo de hello")
  public void helloFromB() {
    log.info("Hello from microservice B");
  }
}
