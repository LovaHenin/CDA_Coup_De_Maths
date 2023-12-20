package com.simplon.coupdemaths.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfigurer {
    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
// Standard pour les REST API
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(securityFilter(),UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(r -> {
                    // r.requestMatchers("/api/v1/**").authenticated();
                    r.requestMatchers("/api/admin/**").hasAuthority("ADMIN");
                    r.requestMatchers("/api/professor/**").hasAuthority("PROFESSOR");
                    r.requestMatchers("/api/student/**").hasAuthority("STUDENT");
                    r.anyRequest().permitAll();
                });
        return http.build();
    }
}
//Remarque : configuration de votre application avec le filter et le endpoint
