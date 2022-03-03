package com.sss.university.student.ms;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.sss.university.student.ms.controller", "com.sss.university.student.ms.service"})
@EntityScan("com.sss.university.student.ms.entity")
@EnableJpaRepositories("com.sss.university.student.ms.repository")
@EnableFeignClients("com.sss.university.student.ms.feignclients")
public class StudentMicroserviceApplication {
	
	@Value("${address.service.url}")
	private String addressServiceURL;

	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public WebClient getWebClint() {
		WebClient webClient = WebClient.builder().baseUrl(addressServiceURL).build();
		return webClient;
	}

}
