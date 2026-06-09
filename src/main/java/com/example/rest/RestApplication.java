package com.example.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Customer Account API",
				version = "1.0",
				description = "REST API for managing Accounts",
				contact = @Contact(
						name = "Thanish"
				)
		)
)
public class RestApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);

	}


}
