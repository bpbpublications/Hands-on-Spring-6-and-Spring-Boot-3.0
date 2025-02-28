package com.bpb.hssb.ch4.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/books/**").authenticated()
                        .anyRequest().permitAll())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/books", true)
                        .permitAll());
        http
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .addLogoutHandler(new SecurityContextLogoutHandler()));

        http
                .anonymous(anonymous -> anonymous
                        .disable());

        return http.build();
    }
}
