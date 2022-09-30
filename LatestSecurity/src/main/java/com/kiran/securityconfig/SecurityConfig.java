package com.kiran.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("kiran")
		.password("$2a$10$4Spq/cXt2G1HjWXUWEjcyuW7T8mbSevtcnxgAfzvtm.vou9tS2k4W")
		.roles("USER")
		.and()
		
		.withUser("raghu")
		.password("$2a$10$4Spq/cXt2G1HjWXUWEjcyuW7T8mbSevtcnxgAfzvtm.vou9tS2k4W")
		.roles("ADMIN")
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/", "/welcome").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
//		.loginPage("/login")
//        .permitAll()
		.defaultSuccessUrl("/welcome",true)
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
//		.and()
//		.exceptionHandling()
//		.accessDeniedPage("/accessDenied");
		;
	}
	
}
