package com.example.upday.newscore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class NewsCoreApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(NewsCoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(NewsCoreApplication.class, args);
	}
}
