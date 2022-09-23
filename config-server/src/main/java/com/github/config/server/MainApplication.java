package com.github.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class MainApplication {
	public static void main(String[] args) {
		 SpringApplication.run(MainApplication.class, args);
		/*
		 * Map<String, Integer> certificationCost = new HashMap<>();
		 * certificationCost.put("OCAJP 1Z0-808", 248);
		 * certificationCost.put("OCPJP 1Z0-809", 248);
		 * certificationCost.put("Spring Professional Certification Exam", 200);
		 * certificationCost.put("Spring Web Application Developer Exam", 200);
		 * certificationCost.put("OCMJEA 1Z0-807", 600);
		 * 
		 * // let's try to remove element from Hashmap using Map.remove(Object key)
		 * method // this will not work, will throw ConcurrentModfiicationException
		 * Set<String> setOfCertifications = certificationCost.keySet();
		 * 
		 * for (String certificaiton : setOfCertifications) {
		 * 
		 * if (certificaiton.contains("OCMJEA")) {
		 * certificationCost.remove(certificaiton); } }
		 */
	}
}
