package com.example.hotelmanagementsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {


    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/homepage","/user/**","/admin/**","/css/**","/js/**","/png/**","/jpg/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/homepage")
                .defaultSuccessUrl("/dashboard",true)
                .usernameParameter("email")
                .permitAll()
                .and()
                .httpBasic();
        return httpSecurity.build();
    }
}
