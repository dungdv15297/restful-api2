package com.emwa.service;

import org.springframework.stereotype.Service;

import com.emwa.model.LeaveRequest;
import com.emwa.result.ServiceResult;
@Service
public interface LeaveRequestService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(LeaveRequest lr);
	public ServiceResult update(LeaveRequest lr);
	public ServiceResult delete(long id);
}
