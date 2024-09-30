package com.mindHub.waveCenter;

import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WaveCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaveCenterApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {

		return args -> {
			Client ludwing = new Client("Ludwing", "valecillos", "ludwing@gmail.com", passwordEncoder.encode("ludwing"));

			clientRepository.save(ludwing);
		};
	}
}
