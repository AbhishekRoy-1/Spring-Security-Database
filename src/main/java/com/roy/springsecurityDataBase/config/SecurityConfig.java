package com.roy.springsecurityDataBase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc

public class SecurityConfig{
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.
				csrf()
				.disable()
				.authorizeHttpRequests()
			    .requestMatchers("/rest/**")
			    .authenticated()
			    .anyRequest()
			    .permitAll()
			    .and()
			    .formLogin();
		
		http.authenticationProvider(daoAuthenticationProvider());
		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		
		return defaultSecurityFilterChain;
		
	}

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
    	DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
    	provider.setUserDetailsService(this.userDetailsService);
    	provider.setPasswordEncoder(passwordEncoder());
		return provider;
    	
    }
	
    @Bean
    AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();

    }
	
}