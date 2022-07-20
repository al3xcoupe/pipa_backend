package ch.am.axa.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class BackendApplication {

	public static void main(String[] args) {
		System.out.println("a");
		SpringApplication.run(BackendApplication.class, args);
	}

}
