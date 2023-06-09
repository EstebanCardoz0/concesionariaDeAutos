package com.concesionaria.concesionaria;

import javax.annotation.security.PermitAll;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SeguridadWeb extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {

http.authorizeRequests().antMatchers("/css/*", "/js/*", "/img/*", "/**").permitAll();

    }

}
