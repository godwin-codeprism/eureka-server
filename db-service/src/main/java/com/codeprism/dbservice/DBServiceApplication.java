package com.codeprism.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.codeprism.dbservice.Repositories")
@SpringBootApplication
public class DBServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBServiceApplication.class, args);
	}

}
