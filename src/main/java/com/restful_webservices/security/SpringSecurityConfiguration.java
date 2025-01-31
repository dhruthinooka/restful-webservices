package com.restful_webservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// Authenticate all requests
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		// Enable Basic Auth with Default settings
		http.httpBasic(withDefaults());
		
		// Disable CSRF to execute POST & PUT requests using Spring Security
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

}
