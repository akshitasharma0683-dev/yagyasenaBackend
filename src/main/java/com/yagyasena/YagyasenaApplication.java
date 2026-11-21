package com.yagyasena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
@EntityScan(basePackages = "com.entity")
@SpringBootApplication
public class YagyasenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YagyasenaApplication.class, args);
	}

}
