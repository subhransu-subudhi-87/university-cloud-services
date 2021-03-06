package com.sss.university.address.ms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sss.university.address.ms.controller", "com.sss.university.address.ms.service"})
@EntityScan("com.sss.university.address.ms.entity")
@EnableJpaRepositories("com.sss.university.address.ms.repository")
@EnableEurekaClient
public class AddressMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressMicroserviceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
