package com.sss.university.student.ms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sss.university.student.ms.response.AddressResponse;

@FeignClient(url="${address.service.url}",value="address-feign-client",path="/api/address-service")
public interface AddressFeignClient {
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id);
}
