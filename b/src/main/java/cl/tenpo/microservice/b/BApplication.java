package cl.tenpo.microservice.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BApplication {


	public static void main(String[] args) {
		SpringApplication.run(BApplication.class, args);
	}

}
