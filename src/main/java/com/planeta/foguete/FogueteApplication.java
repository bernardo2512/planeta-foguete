package com.planeta.foguete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FogueteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FogueteApplication.class, args);
	}

}
