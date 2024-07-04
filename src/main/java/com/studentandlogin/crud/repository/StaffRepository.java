package com.studentandlogin.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentandlogin.crud.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}
