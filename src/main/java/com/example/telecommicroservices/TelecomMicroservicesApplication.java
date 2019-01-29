package com.example.telecommicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
@ComponentScan({"com.example.telecommicroservices.controller"})
public class TelecomMicroservicesApplication {
	
	static Logger logger = LogManager.getLogger(TelecomMicroservicesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TelecomMicroservicesApplication.class, args);
		logger.debug("The application has been started. Please proceed with the actions");
	}

}

