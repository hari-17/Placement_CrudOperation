package com.practice.demo;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.example.model")



public class DemoApplication {

	public static void main(String[] args) {



		System.out.println("Hello Startdddd...");
		SpringApplication.run(DemoApplication.class, args);
	}


}
