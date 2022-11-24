package com.hotel.api.book;

import com.hotel.api.book.model.SupplierCredential;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigurationProperties(SupplierCredential.class)
@EnableEurekaClient
@SpringBootApplication
public class HotelBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookServiceApplication.class, args);
	}

}
