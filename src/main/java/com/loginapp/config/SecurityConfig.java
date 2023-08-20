package com.loginapp.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean 
	public UserDetailsService userDetailsService() {
		return new UserServiceDetailsImpl();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	   DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	   daoAuthenticationProvider.setUserDetailsService(userDetailsService());
	   daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	   return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(csrf->{
			try {
				csrf.disable()
				.authorizeHttpRequests(authz->authz
						.requestMatchers("/createUser","/register","/logout")
						.permitAll()
						.anyRequest()
						.authenticated())
				.formLogin(login->login
						.loginPage("/signin")
						.loginProcessingUrl("/login")
						.permitAll());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		httpSecurity.authenticationProvider(authenticationProvider());
		
		return httpSecurity.build();
		
	}
}
