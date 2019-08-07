package com.balti.restaurant.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestaurantSysAPI {

	public static void main(String[] args){
		SpringApplication.run(RestaurantSysAPI.class, args);
	}
}
