package com.sss.university.student.ms.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sss.university.student.ms.entity.Student;
import com.sss.university.student.ms.repository.StudentRepository;
import com.sss.university.student.ms.request.CreateStudentRequest;
import com.sss.university.student.ms.response.AddressResponse;
import com.sss.university.student.ms.response.StudentResponse;

import reactor.core.publisher.Mono;



@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	WebClient webClient;


	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

//		Address address = new Address();
//		address.setStreet(createStudentRequest.getStreet());
//		address.setCity(createStudentRequest.getCity());
//
//		address = addressRepository.save(address);
		Student student = mapper.map(createStudentRequest, Student.class);
//		Student student = new Student();
//		student.setFirstName(createStudentRequest.getFirstName());
//		student.setLastName(createStudentRequest.getLastName());
//		student.setEmail(createStudentRequest.getEmail());
//		student.setAddressId(createStudentRequest.getAddressId());
//		student.setAddress(address);
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}
	
	public StudentResponse getStudentByIdUsingWebClient (long id) {
		Student studentObject = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(studentObject);
		studentResponse.setAddressResponse(getAddressById(id));
		return studentResponse;
	}

	//Intercommunication between services using Web-Client
	public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/"+addressId).retrieve().bodyToMono(AddressResponse.class);
		return addressResponse.block();
	}
	
}
