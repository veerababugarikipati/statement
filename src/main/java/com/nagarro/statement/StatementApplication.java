package com.nagarro.statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatementApplication {
	Logger logger = LoggerFactory.getLogger(StatementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StatementApplication.class, args);
	}

}
