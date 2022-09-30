package com.kiran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@SpringBootApplication
public class RolesBasedSecurityAppApplication {
	/*
	 * public void configureViewResolvers(ViewResolverRegistry registry) {
	 * registry.viewResolver(new ThymeleafViewResolver());
	 * InternalResourceViewResolver internalResourceViewResolver = new
	 * InternalResourceViewResolver();
	 * internalResourceViewResolver.setViewClass(JstlView.class);
	 * internalResourceViewResolver.setPrefix("/WEB-INF/pages");
	 * internalResourceViewResolver.setSuffix(".jsp");
	 * registry.viewResolver(internalResourceViewResolver); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(RolesBasedSecurityAppApplication.class, args);
	}

}
