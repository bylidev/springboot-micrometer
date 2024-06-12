package cl.tenpo.microservice.b;

import io.micrometer.tracing.SpanName;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

@RestController
@Slf4j
public class Controller {

  @GetMapping("/b")
  @SpanName("flujo de agregacion complentaria")
  public void hello(HttpServletRequest request) {
    Enumeration<String> headerNames = request.getHeaderNames();

    log.info("Hello from microservice B");
  }

}
