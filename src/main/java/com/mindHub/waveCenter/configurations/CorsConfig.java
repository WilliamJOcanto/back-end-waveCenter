package com.mindHub.waveCenter.configurations;

import io.jsonwebtoken.lang.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList(new String[]{"http://localhost:8080", "http://localhost:8080/h2-console"}));

        configuration.setAllowedMethods(Arrays.asList(new String[]{"GET", "POST", "PUT", "DELETE"}));

        configuration.setAllowedHeaders(List.of("*"));


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();


        source.registerCorsConfiguration("/**", configuration);


        return source;
    }
}
