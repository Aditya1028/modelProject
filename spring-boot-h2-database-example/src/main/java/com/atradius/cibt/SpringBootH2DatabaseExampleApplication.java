package com.atradius.cibt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootH2DatabaseExampleApplication extends SpringBootServletInitializer{
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
	    return builder.sources(SpringBootH2DatabaseExampleApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
	}
}
	