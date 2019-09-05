package com.optika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan( basePackages = {"com.optika.model"})
public class OptikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptikaApplication.class, args);
	}

}
