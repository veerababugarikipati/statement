package com.nagarro.statement.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	Logger logger = LoggerFactory.getLogger(WebSecurityConfigurerAdapter.class);
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(inMemoryUserDetailsManager());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		    .csrf()
		    .disable()

			.authorizeRequests()
			.antMatchers("/","/home","/login").permitAll()
			.antMatchers("/admin*","/statement/**").hasRole("ADMIN")
			.antMatchers("/user*","/statement/**").hasAnyRole("USER","ADMIN")
			.anyRequest().authenticated()
			.and()
		    .formLogin()
		    .loginPage("/login")
		    .defaultSuccessUrl("/home")
		    .permitAll()
		    .and()
		    .logout()
		    .and()
		    .sessionManagement()         
		    .maximumSessions(1);
		   // .maxSessionsPreventsLogin(true);

	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager()
	{
		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(User.withUsername("user").password(passwordEncoder().encode("user"))
				.roles("USER", "USER").build());
		userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("admin"))
				.roles("ADMIN", "ADMIN").build());
		return new InMemoryUserDetailsManager(userDetailsList);
	}
}