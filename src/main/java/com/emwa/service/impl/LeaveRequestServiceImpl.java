package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emwa.model.LeaveRequest;
import com.emwa.repository.LeaveRequestRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.LeaveRequestService;
@Service
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
	    if(lr!=null) {
	    	result.setMessage("Leave request "+lr.getLrId()+" has been founded!");
	    }else {
	    	result.setMessage("Can not find any leave request!");
	    }
	    return result;
	}

	@Override
	public ServiceResult create(LeaveRequest lr) {
		ServiceResult result = new ServiceResult();
		LeaveRequest lrq = lrRepository.save(lr);
		result.setData(lrq);
		if(lrq!=null) {
			result.setMessage("Leave request "+lrq.getLrId()+" has been created!");
		}else {
			result.setMessage("Can not create any leave requests!");
		}
		return result;
	}

	@Override
	public ServiceResult update(LeaveRequest lr) {
		ServiceResult result = new ServiceResult();
		if (!lrRepository.findById(lr.getLrId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("LeaveRequest Not Found");
		} else {
			LeaveRequest lrq = lrRepository.save(lr);
			result.setData(lrq);
			result.setMessage("Leave request "+lrq.getLrId()+" has been updated!");
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
			result.setMessage("Leave request "+lr.getLrId()+" has been deleted!");
		}
		return result;
	}
}
