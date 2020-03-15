package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emwa.model.Staff;
import com.emwa.repository.StaffRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.StaffService;

public class StaffServiceImpl implements StaffService {
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(staffRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
	    Staff staff = staffRepository.findById(id).orElse(null);
	    result.setData(staff);
	    if(staff!=null) {
	    	result.setMessage("Staff "+staff.getStaffId()+" has been founded!");
	    }else {
	    	result.setMessage("Can not find any staff!");
	    }
	    return result;
	}

	@Override
	public ServiceResult create(Staff staff) {
		ServiceResult result = new ServiceResult();
		Staff stf = staffRepository.save(staff);
		result.setData(stf);
		if(stf!=null) {
			result.setMessage("Staff "+stf.getStaffId()+" has been created!");
		}else {
			result.setMessage("Can not create any new staff!");
		}
		return result;
	}

	@Override
	public ServiceResult update(Staff staff) {
		ServiceResult result = new ServiceResult();
		if (!staffRepository.findById(staff.getStaffId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Staff Not Found");
		} else {
			Staff stf = staffRepository.save(staff);
			result.setData(stf);
			result.setMessage("Staff "+stf.getStaffId()+" has been updated!");
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		Staff staff = staffRepository.findById(id).orElse(null);
		if (staff == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Staff Not Found");
		} else {
			staffRepository.delete(staff);
			result.setMessage("Staff "+staff.getStaffId()+" has been deleted!");
		}
		return result;
	}
}
