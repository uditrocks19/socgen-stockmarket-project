package com.udit.excelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import java.util.Collections;

@EnableSwagger2

@SpringBootApplication
@EnableDiscoveryClient
public class ExcelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelServiceApplication.class, args);
	}
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.udit"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Company Microservice API",
				"API Documentation for Company Microservice",
				"1.0",
				"Copyright-Udit Raj Mahajan",
				new Contact("Udit Raj Mahajan", "https://github.com/uditrocks19", "udit.iitr17@gmail.com"),
				"API License",
				"https://github.com/uditrocks19/socgen-stockmarket-project",Collections.emptyList());
	}
}