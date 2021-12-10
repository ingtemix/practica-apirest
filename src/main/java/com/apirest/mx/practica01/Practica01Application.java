package com.apirest.mx.practica01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({ "com.apirest.mx.practica01.*" })
public class Practica01Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Practica01Application.class, args);
		System.out.println("HOLA");
	}
}
