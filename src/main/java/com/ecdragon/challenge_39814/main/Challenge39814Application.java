package com.ecdragon.challenge_39814.main;

import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ecdragon.challenge_39814"})
public class Challenge39814Application {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		logger.info("Starting Challenge39814Application.");
		SpringApplication.run(Challenge39814Application.class, args);
	}

	@PostConstruct
	void started() {
		logger.info("--------------------------------------------------------------------------------------------------");
		logger.info("\n" + 
				"  ______  __    __       ___       __       __       _______ .__   __.   _______  _______ ____     ___     ___    __   _  _    \n" + 
				" /      ||  |  |  |     /   \\     |  |     |  |     |   ____||  \\ |  |  /  _____||   ____|___ \\   / _ \\   / _ \\  /_ | | || |   \n" + 
				"|  ,----'|  |__|  |    /  ^  \\    |  |     |  |     |  |__   |   \\|  | |  |  __  |  |__    __) | | (_) | | (_) |  | | | || |_  \n" + 
				"|  |     |   __   |   /  /_\\  \\   |  |     |  |     |   __|  |  . `  | |  | |_ | |   __|  |__ <   \\__, |  > _ <   | | |__   _| \n" + 
				"|  `----.|  |  |  |  /  _____  \\  |  `----.|  `----.|  |____ |  |\\   | |  |__| | |  |____ ___) |    / /  | (_) |  | |    | |   \n" + 
				" \\______||__|  |__| /__/     \\__\\ |_______||_______||_______||__| \\__|  \\______| |_______|____/    /_/    \\___/   |_|    |_|   \n" + 
				"                                                                                                                               \n" + 
				"");
		logger.info("\nChallenge39814 started!!");
		logger.info("--------------------------------------------------------------------------------------------------");
	}
}
