package com.CarRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.el.BeanNameResolver;


@SpringBootApplication
@EnableAutoConfiguration
public class CarRentalProjectApplication {



	public static void main(String[] args) {

		SpringApplication.run(CarRentalProjectApplication.class, args);
	}

}
