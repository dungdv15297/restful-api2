package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emwa.model.LeaveRequest;
import com.emwa.repository.LeaveRequestRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.LeaveRequestService;

public class LeaveRequestServiceImpl implements LeaveRequestService {
	@Autowired
	LeaveRequestRepository lrRepository;
	
	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(lrRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
	    LeaveRequest lr = lrRepository.findById(id).orElse(null);
	    result.setData(lr);
	    return result;
	}

	@Override
	public ServiceResult create(LeaveRequest lr) {
		ServiceResult result = new ServiceResult();
		result.setData(lrRepository.save(lr));
		return result;
	}

	@Override
	public ServiceResult update(LeaveRequest lr) {
		ServiceResult result = new ServiceResult();
		if (!lrRepository.findById(lr.getLrId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("LeaveRequest Not Found");
		} else {
			result.setData(lrRepository.save(lr));
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		LeaveRequest lr = lrRepository.findById(id).orElse(null);
		if (lr == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Leave Request Not Found");
		} else {
			lrRepository.delete(lr);
			result.setMessage("Delete Success");
		}
		return result;
	}
}
