package com.rest.webservices.example.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
@Autowired
private MessageSource messageSource;
     
	@GetMapping(path="/hello-world")
	public String hello(){
		return "helloooo";
		
	}
	@GetMapping(path="/hello-world-inter")
	public String helloInternationalize(){
		return messageSource.getMessage("good.morning.message", null 
				,LocaleContextHolder.getLocale());
		
	}
	   
		
	
	   
		@GetMapping(path="/hello-world-bean")
		public helloWorldBean helloBean(){
			return new helloWorldBean("hello");
			
		}

		   
		@GetMapping(path="/hello-world-bean/{name}")
		public helloWorldBean helloBeanPathVariable( @PathVariable String name){
			return new helloWorldBean(String.format("hello, %s",name));
			
		}
		
	
	
}
