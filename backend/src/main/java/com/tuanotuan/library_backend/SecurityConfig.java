package com.tuanotuan.library_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt cái này để lát nữa làm Login cho dễ
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/books/**").permitAll() // Cho phép xem sách KHÔNG cần login
                        .anyRequest().authenticated() // Các đường dẫn khác vẫn phải login
                )
                .formLogin(form -> form.permitAll()); // Vẫn giữ trang login để test

        return http.build();
    }
}