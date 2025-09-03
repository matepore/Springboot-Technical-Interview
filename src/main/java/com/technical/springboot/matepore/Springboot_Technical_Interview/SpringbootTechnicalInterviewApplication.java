package com.technical.springboot.matepore.Springboot_Technical_Interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootTechnicalInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTechnicalInterviewApplication.class, args);
	}

}
