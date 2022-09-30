package com.kiran.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService  service;
	
	@Autowired
	private BCryptPasswordEncoder passencoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("sec config 11111111111111111 ");
		auth.userDetailsService(service).passwordEncoder(passencoder);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("sec config 2222 ");
		http.authorizeRequests()
		.antMatchers("/home","/register","/saveUser").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("Admin")
		.antMatchers("/mgr").hasAuthority("Manager")
		.antMatchers("/emp").hasAuthority("Employee")
		.antMatchers("/hr").hasAuthority("HR")
		.antMatchers("/common").hasAnyAuthority("Employeee,Manager,Admin")
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		
		.loginPage("/login")
        .permitAll()
		.defaultSuccessUrl("/welcome",true)
		
//		 .formLogin()
//         .loginPage("/login")
//         .permitAll()
//         .defaultSuccessUrl("/welcome")
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");
		
		
		
		
		
		/*
		
		 http.authorizeRequests()
		 .antMatchers("/home","/register","/saveUser,/kiran").permitAll()
			.antMatchers("/welcome").authenticated()
			.antMatchers("/admin").hasAuthority("Admin")
			.antMatchers("/mgr").hasAuthority("Manager")
			.antMatchers("/emp").hasAuthority("Employee")
			.antMatchers("/hr").hasAuthority("HR")
			.antMatchers("/common").hasAnyAuthority("Employeee,Manager,Admin")
			.anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login")
         .permitAll()
         .defaultSuccessUrl("/welcome")
         .and()
         .logout()
 		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
 		.permitAll()
 		.and()
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");
         ;
		/*
		http.authorizeRequests()
		.antMatchers("/home","/register","/saveUser,/kiran").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("Admin")
		.antMatchers("/mgr").hasAuthority("Manager")
		.antMatchers("/emp").hasAuthority("Employee")
		.antMatchers("/hr").hasAuthority("HR")
		.antMatchers("/common").hasAnyAuthority("Employeee,Manager,Admin")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/welcome",true)
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.and()
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");
		*/
		
		
	}
	
	
}
