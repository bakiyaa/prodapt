package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(org.springframework.http.HttpMethod.GET, "/**").authenticated()
                        .anyRequest().permitAll() // Allow other HTTP methods (POST, PUT, DELETE)
                )
                .httpBasic(Customizer.withDefaults());

        http.headers().frameOptions().disable(); // Needed for H2 Console UI

        return http.build();
    }
}

