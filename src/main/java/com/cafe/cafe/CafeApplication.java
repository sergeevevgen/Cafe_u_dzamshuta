package com.cafe.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "data")
@EntityScan(basePackages = "data")
@ComponentScan(basePackages = {"admin", "client", "manager", "com.cafe.cafe"})
@SpringBootApplication
public class CafeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}
}
