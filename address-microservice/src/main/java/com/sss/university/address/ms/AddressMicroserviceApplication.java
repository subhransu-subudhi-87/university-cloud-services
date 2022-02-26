package com.sss.university.address.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sss.university.address.ms.controller", "com.sss.university.address.ms.service"})
@EntityScan("com.sss.university.address.ms.entity")
@EnableJpaRepositories("com.sss.university.address.ms.repository")
public class AddressMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressMicroserviceApplication.class, args);
	}

}
