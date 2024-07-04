package com.studentandlogin.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentandlogin.crud.model.Student;
import com.studentandlogin.crud.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAllStudent() {
		
		return studentRepository.findAll();
	}
	public Student saveDetailsStudent(Student student) {
		return studentRepository.save(student);
	}
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
	public Student updatePut(Long id, Student student) {
	Student existingStudent=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student id not found"));
	existingStudent.setId(student.getId());
	existingStudent.setName(student.getName());
		return studentRepository.save(existingStudent);
	}
	public Student updatePatch(Long id, Student student) {
		Student existingNotNullStudent=studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student id is not found"));
		
		if(student.getId()!=null) {
			existingNotNullStudent.setId(student.getId());
		}
		
		if(student.getName()!=null) {
			existingNotNullStudent.setName(student.getName());
		}
		
		return studentRepository.save(existingNotNullStudent);
	}	
}
