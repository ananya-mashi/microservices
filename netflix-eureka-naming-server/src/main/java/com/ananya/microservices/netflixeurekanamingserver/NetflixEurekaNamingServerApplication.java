package com.ananya.microservices.netflixeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaNamingServerApplication.class, args);
	}

}
