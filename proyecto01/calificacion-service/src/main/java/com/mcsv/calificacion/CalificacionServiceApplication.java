package com.mcsv.calificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CalificacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalificacionServiceApplication.class, args);
	}

}
