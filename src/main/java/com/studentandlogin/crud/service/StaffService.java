package com.studentandlogin.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentandlogin.crud.model.Staff;
import com.studentandlogin.crud.repository.StaffRepository;

@Service
public class StaffService{
	
	@Autowired
	private StaffRepository staffRepository;

	public Optional<Staff> findById(Long id) {
		
		return staffRepository.findById(id);
	}

	public Staff save(Staff staff) {
		
		return staffRepository.save(staff);
	}


	public Staff updatPutStaff(Long id, Staff staff) {
		Staff updateStaffDetails=staffRepository.findById(id).orElseThrow(()->new RuntimeException("Staff Id not found"));
		
		updateStaffDetails.setId(staff.getId());
		updateStaffDetails.setName(staff.getName());
		
		return staffRepository.save(updateStaffDetails);
	}


	public Staff updatePatchStaff(long id, Staff staff) {
		Staff updateStaffPartial=staffRepository.findById(id).orElseThrow(()->new RuntimeException("Staff Id not found"));
		
		if (updateStaffPartial.getId()!=null){
			updateStaffPartial.setId(staff.getId());
		}
		
		if(updateStaffPartial.getName()!=null) {
			updateStaffPartial.setName(staff.getName());
		}
		return staffRepository.save(updateStaffPartial);
	}
	
	
    public void deleteById(Long id) {
		
		staffRepository.deleteById(id);
	}
}
