package com.emwa.service;

import com.emwa.model.Staff;
import com.emwa.result.ServiceResult;

public interface StaffService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Staff staff);
	public ServiceResult update(Staff staff);
	public ServiceResult delete(long id);
}
