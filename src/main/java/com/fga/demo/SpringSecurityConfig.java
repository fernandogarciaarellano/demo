package com.fga.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/Contract**", "/Employee**")
			.hasRole("USER")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		userDetailsList.add(
				User.withUsername("metaphorce")
					.password(passwordEncoder()
					.encode("m3t4Ph0rc3"))
					.roles("USER")
					.build());

		return new InMemoryUserDetailsManager(userDetailsList);
	}
}
