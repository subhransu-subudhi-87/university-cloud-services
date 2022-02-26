package com.sss.university.address.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.university.address.ms.request.CreateAddressRequest;
import com.sss.university.address.ms.response.AddressResponse;
import com.sss.university.address.ms.service.AddressService;

@RestController
@RequestMapping("/api/address-service")
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@PostMapping("/createAddress")
	public AddressResponse createAddress(@RequestBody CreateAddressRequest addRequest) {
		return addressService.createAddress(addRequest);
	}
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id) {
		return addressService.getById(id);
	}
}
