package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emwa.model.Account;
import com.emwa.model.Depart;
import com.emwa.repository.AccountRepository;
import com.emwa.repository.DepartRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.DepartService;

public class DepartServiceImpl implements DepartService{
	@Autowired
	DepartRepository departRepository;
	
	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(departRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
	    Depart depart = departRepository.findById(id).orElse(null);
	    result.setData(depart);
	    return result;
	}

	@Override
	public ServiceResult create(Depart depart) {
		ServiceResult result = new ServiceResult();
		result.setData(departRepository.save(depart));
		return result;
	}

	@Override
	public ServiceResult update(Depart depart) {
		ServiceResult result = new ServiceResult();
		if (!departRepository.findById(depart.getDepartId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Depart Not Found");
		} else {
			result.setData(departRepository.save(depart));
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		Depart depart = departRepository.findById(id).orElse(null);
		if (depart == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Depart Not Found");
		} else {
			departRepository.delete(depart);
			result.setMessage("Delete Success");
		}
		return result;
	}
}
