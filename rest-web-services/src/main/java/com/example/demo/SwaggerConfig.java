package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configure
//enable swagger2
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//Bean - Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
		
	}
	
	// swagger 2
	// all the paths
	// all the apis
	
	
}
