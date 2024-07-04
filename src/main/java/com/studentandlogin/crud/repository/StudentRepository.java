package com.studentandlogin.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentandlogin.crud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
