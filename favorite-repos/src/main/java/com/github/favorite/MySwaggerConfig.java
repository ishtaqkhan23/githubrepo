package com.github.favorite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//This annotation enables the Swagger support in the application.
@EnableSwagger2
public class MySwaggerConfig {

	// The select() method called on Docket bean returns an "ApiSelectorBuilder".
	// This provides "apis()" and "paths()" methods to filter the controllers and
	// methods being documented using string predicates.
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Github Favorite API").description("API for developers")
				.termsOfServiceUrl("https://www.github.com/").version("1.0").build();
	}
}
