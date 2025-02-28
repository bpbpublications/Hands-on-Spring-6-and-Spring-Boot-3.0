package com.bpb.hssb.ch5.bookclub.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
public class SecurityConfiguration {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers("/books/add").hasRole("ADMIN")
                                                .requestMatchers("/books/**").hasAnyRole("ADMIN", "USER")
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
                http
                        .exceptionHandling((exceptions) -> exceptions
                                                .accessDeniedPage("/error/default")); 
                    

                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {

                List<UserDetails> users = new ArrayList<>();

                users.add(User.withDefaultPasswordEncoder()
                                .username("sam")
                                .password("abcd")
                                .roles("USER", "ADMIN")
                                .build());

                users.add(User.withDefaultPasswordEncoder()
                                .username("alex")
                                .password("abcd")
                                .roles("USER")
                                .build());

                return new InMemoryUserDetailsManager(users);
        }

}
