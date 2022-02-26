package com.sss.university.student.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sss.university.student.ms.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	
}
