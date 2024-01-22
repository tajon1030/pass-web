package com.fastcampus.passweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PassWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassWebApplication.class, args);
	}

}
