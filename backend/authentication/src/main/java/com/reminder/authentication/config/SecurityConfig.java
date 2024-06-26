package com.reminder.authentication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @Autowired private UserDetailsService userDetailsService;

  Logger log = LoggerFactory.getLogger(SecurityConfig.class);

  @Override
  @Autowired
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    log.debug("SecurityConfig::configure");
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    log.debug("SecurityConfig::authenticationManager");
    return super.authenticationManager();
  }
}