package com.demoex.try2.Config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
    @Bean
    public static SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/signup").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((login) -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/main")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}