package cl.tenpo.microservice;

import java.util.concurrent.Executor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.support.ContextPropagatingTaskDecorator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
  private RestClient restClient;
  public void getSyncB() {
    restClient.get().uri("http://localhost:8081/b").retrieve();
  }

  @Async("asyncTaskExecutor")
  public void getAsyncB() {
    restClient.get().uri("http://localhost:8081/b").retrieve();
  }

  @Bean("asyncTaskExecutor")
  public Executor asyncTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(20);
    executor.setMaxPoolSize(20);
    executor.setQueueCapacity(10);
    executor.setKeepAliveSeconds(1);
    executor.setThreadNamePrefix("test");
    executor.initialize();
    executor.setTaskDecorator(new ContextPropagatingTaskDecorator());
    return executor;
  }
}
