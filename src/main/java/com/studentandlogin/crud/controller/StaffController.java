package com.studentandlogin.crud.controller;

import java.util.List;
import java.util.Optional;

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

import com.studentandlogin.crud.model.Staff;
import com.studentandlogin.crud.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/{id}")
	public Optional <Staff> findByStaffId(@PathVariable Long id){
		return staffService.findById(id);
	}
	
	@PostMapping("/create")
	public Staff createStaff(@RequestBody Staff staff) {
		return staffService.save(staff);
	}
	
	@PutMapping("/update/{id}")
	public Staff updatePutStaff(@PathVariable Long id, @RequestBody Staff staff) {
		return staffService.updatPutStaff(id,staff);
	}
	
	@PatchMapping("/partialupdate/{id}")
	public Staff updatePatchStaff(@PathVariable long id, @RequestBody Staff staff) {
		return staffService.updatePatchStaff(id,staff);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		 staffService.deleteById(id);
	}

}
