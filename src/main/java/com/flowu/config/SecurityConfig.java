package com.flowu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final ExternalAuthFilter externalAuthFilter;

    @Autowired
    public SecurityConfig(ExternalAuthFilter externalAuthFilter) {
        this.externalAuthFilter = externalAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/health").permitAll();
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(externalAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
