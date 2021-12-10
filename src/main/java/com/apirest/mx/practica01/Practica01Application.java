package com.apirest.mx.practica01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "com.apirest.mx.practica01" })
public class Practica01Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Practica01Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Practica01Application.class);
	}
}
