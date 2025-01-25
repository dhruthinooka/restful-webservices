package com.restful_webservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	// Constructor injection
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	// /hello-world
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		
		return "Hello World";	
		
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello World");	
		
	}
	
	//Path parameters
	// /hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//		 return new HelloWorldBean(String.format("Hello World, %s", name));
		return new HelloWorldBean("Hello World, " + name);	
		
	}
	
	@GetMapping(path = "/hello-world-internalionalized")
	public String helloWorldInternalionalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale );		
	}
	

}
