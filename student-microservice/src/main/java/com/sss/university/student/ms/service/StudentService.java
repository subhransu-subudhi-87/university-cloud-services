package com.sss.university.student.ms.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.university.student.ms.entity.Student;
import com.sss.university.student.ms.repository.StudentRepository;
import com.sss.university.student.ms.request.CreateStudentRequest;
import com.sss.university.student.ms.response.StudentResponse;



@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ModelMapper mapper;


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

		return new StudentResponse(student);
	}
	
	public StudentResponse getById (long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}
}
