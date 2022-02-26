package com.sss.university.address.ms.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.university.address.ms.entity.Address;
import com.sss.university.address.ms.repository.AddressRepository;
import com.sss.university.address.ms.request.CreateAddressRequest;
import com.sss.university.address.ms.response.AddressResponse;

@Service
public class AddressService {
	
	Logger logger  = LoggerFactory.getLogger(AddressService.class);

	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	ModelMapper mapper;
	
	public AddressResponse createAddress(CreateAddressRequest addRequest) {
//		Address address = new Address();
		Address address = mapper.map(addRequest, Address.class);
		Address savedEntity = addressRepo.save(address);
		return new AddressResponse(savedEntity);
	}

	public AddressResponse getById(long id) {
		Optional<Address> addById =  Optional.ofNullable(addressRepo.findById(id).get());
		if(addById.isPresent()) {
			return new AddressResponse(addById.get());
		  }
		return null;
	}

}
