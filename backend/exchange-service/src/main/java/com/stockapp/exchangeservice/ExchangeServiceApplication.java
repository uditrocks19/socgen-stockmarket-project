package com.stockapp.exchangeservice;



import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;





@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2



public class ExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeServiceApplication.class, args);
	}
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.stockapp")).build()
	         .apiInfo(apiDetails());
	   }
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Stock Exchange Microservice API",
				"API Documentation for Stock Exchange Application",
				"1.0",
				"Copyright- Udit Raj",
				new springfox.documentation.service.Contact("Udit Raj", "https://github.com/uditrocks19/socgen-stockmarket-project", "udit.iitr17@gmail.com"),
				"API License",
				"https://github.com/Uditrocks19/socgen-stockmarket-project",
				Collections.emptyList());
	}
	
	
}