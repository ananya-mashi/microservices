package com.rest.webservices.example;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
	@Bean
	public LocaleResolver localeRe(){
		AcceptHeaderLocaleResolver localeRe=new AcceptHeaderLocaleResolver();
		localeRe.setDefaultLocale(Locale.US);
		return localeRe;
		
	}
	
	
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource =new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		
		return messageSource;
		
	}


}
