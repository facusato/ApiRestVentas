package com.unla.ApiRestVentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ApiRestVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestVentasApplication.class, args);
	}

}
