package com.cafe.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"admin", "client", "manager", "com.cafe.cafe"})
@SpringBootApplication
public class CafeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}
}
