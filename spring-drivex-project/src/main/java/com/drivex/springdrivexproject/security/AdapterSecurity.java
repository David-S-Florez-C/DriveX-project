package com.drivex.springdrivexproject.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdapterSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests(a -> a
                .antMatchers("/api/Admin/**","/api/Car/**", "/api/Client/**" ,"/api/Gama/**",
                        "/api/Message/**", "/api/Reservation/**", "/api/Score/**").permitAll()
                .anyRequest().authenticated()
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login();

        http.cors().and().csrf().disable();
    }
}
