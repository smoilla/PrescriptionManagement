package com.divya.services.prescriptionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages={"com.divya.services.pm.jaxrs.api"})
public class Application {
	
public static void main(String args[]){
	SpringApplication.run(Application.class, args);
}
}
