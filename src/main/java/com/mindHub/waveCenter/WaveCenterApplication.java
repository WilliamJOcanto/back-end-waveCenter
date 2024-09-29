package com.mindHub.waveCenter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WaveCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaveCenterApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(){

		return args -> {
			System.out.println("Heelo");
		};
	}
}
