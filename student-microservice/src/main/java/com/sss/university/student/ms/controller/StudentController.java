package com.sss.university.student.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.university.student.ms.request.CreateStudentRequest;
import com.sss.university.student.ms.response.AddressResponse;
import com.sss.university.student.ms.response.StudentResponse;
import com.sss.university.student.ms.service.StudentService;



@RestController
@RequestMapping("/api/student-service")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/createStudent")
	public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}
	
	@GetMapping("getById/{id}")
	public StudentResponse getById (@PathVariable long id) {
		return studentService.getById(id);
	}
	
//	@GetMapping("/getByIdUsingWebClint/{id}")
//	public AddressResponse getAddressById(@PathVariable long id) {
//		return studentService.getAddressById(id);
//	}
}
