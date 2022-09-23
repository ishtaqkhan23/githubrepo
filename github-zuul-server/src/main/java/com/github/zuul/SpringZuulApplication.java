package com.github.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.github.zuul.security.SimpleFilter;

@SpringBootApplication
@EnableEurekaClient // It acts as a eureka client
@EnableZuulProxy // Enable Zuul

public class SpringZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}

	
}