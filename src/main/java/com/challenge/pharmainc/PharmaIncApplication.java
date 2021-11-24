package com.challenge.pharmainc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PharmaIncApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmaIncApplication.class, args);
	}

}
