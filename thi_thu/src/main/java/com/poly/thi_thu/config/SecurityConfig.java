package com.poly.thi_thu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .csrf(csrf -> csrf.disable()) // Tắt CSRF (Cross-Site Request Forgery) cho đơn giản
                .authorizeHttpRequests(auth -> auth // Cấu hình phân quyền cho các request
                        // Cho phép GET cho tất cả
                        .requestMatchers(HttpMethod.GET, "/courses/**", "/students/**").permitAll()
                        // Chỉ ADMIN mới được POST
                        .requestMatchers(HttpMethod.POST, "/courses/**", "/students/**").hasRole("ADMIN")
                        // Chỉ ADMIN mới được PUT
                        .requestMatchers(HttpMethod.PUT, "/courses/**", "/students/**").hasRole("ADMIN")
                        // Chỉ ADMIN mới được DELETE
                        .requestMatchers(HttpMethod.DELETE, "/courses/**", "/students/**").hasRole("ADMIN")
                        // .requestMatchers("/**").permitAll() // Cho phép tất cả các request khác
                        // .requestMatchers("/**").denyAll() // Từ chối tất cả các request khác
                        .anyRequest().authenticated()) // Tất cả các request khác đều cần xác thực
                .formLogin(Customizer.withDefaults()) // Sử dụng form login mặc định
                .httpBasic(Customizer.withDefaults()); // Sử dụng http basic authentication mặc định
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Sử dụng BCryptPasswordEncoder để mã hóa mật khẩu
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
        // Tạo tài khoản ADMIN với username là admin, password là 123456
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();

        // Tạo tài khoản USER với username là user, password là 123456
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
