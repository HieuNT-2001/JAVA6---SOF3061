package com.poly.thi_thu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // private final CustomUserDetailsService userDetailsService;

    // public SecurityConfig(CustomUserDetailsService userDetailsService) {
    // this.userDetailsService = userDetailsService;
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public AuthenticationManager authManager(HttpSecurity http) throws Exception
    // {
    // return http.getSharedObject(AuthenticationManagerBuilder.class)
    // .userDetailsService(userDetailsService)
    // .passwordEncoder(passwordEncoder())
    // .and()
    // .build();
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("hieu")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
