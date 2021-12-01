package com.example.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		log.info("security config...");
		http.authorizeRequests().antMatchers("/").authenticated();
		//http.authorizeRequests().antMatchers("/").permitAll();
		//http.authorizeRequests().antMatchers("/member/**").authenticated();
		//http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		//http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		
		http.formLogin().loginPage("/loginForm");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("build Auth global...");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}12345678").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}12345678").roles("ADMIN");
	}

}
