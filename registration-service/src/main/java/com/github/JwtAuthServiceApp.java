package com.github;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.service.UserService;

@EnableEurekaClient
@SpringBootApplication
public class JwtAuthServiceApp {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		//SpringApplication.run(JwtAuthServiceApp.class, args);
		int[] i = {7,6,4,3,1};
		System.out.println(maxProfit(i));
	}
	public static int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	
	public static int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Value("${github.rabbitmq.queue}")
	String queueName;

	@Value("${github.rabbitmq.exchange}")
	String exchange;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
