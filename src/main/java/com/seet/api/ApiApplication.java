package com.seet.api;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("Sistema online");
	}

}




