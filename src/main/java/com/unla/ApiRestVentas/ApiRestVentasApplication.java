package com.unla.ApiRestVentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class ApiRestVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestVentasApplication.class, args);
	}

}
