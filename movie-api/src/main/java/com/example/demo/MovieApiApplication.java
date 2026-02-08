package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
		
		System.out.println("===============================");
		System.out.println("URL: http://localhost:5000/api/movies");
		System.out.println("===============================");
	}

}
