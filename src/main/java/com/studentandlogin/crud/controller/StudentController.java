package com.studentandlogin.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentandlogin.crud.model.Student;
import com.studentandlogin.crud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/viewall")
	public List<Student> findByUserName() {
		return studentService.findAllStudent();
	}
	
	@PostMapping("/create")
	public Student  saveStudentDetails(@RequestBody Student student) {
		return studentService.saveDetailsStudent(student);
	}
	
	@PutMapping("/update/{id}")
	public Student updatePutStudentDetails(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updatePut(id,student);
	}
	
	@PatchMapping("/partialupdate/{id}")
	public Student updatepatchStudentDetails(@PathVariable Long id,@RequestBody Student student) {
		return studentService.updatePatch(id,student);
	}
		
	@DeleteMapping("/delete/{id}")
	public void deleteStudentDetails(@PathVariable Long id) {
		studentService.deleteById(id);
	}
	
}
