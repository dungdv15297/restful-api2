package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emwa.model.Depart;
import com.emwa.repository.DepartRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.DepartService;
@Service
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
	    if(depart!=null) {
	    	result.setMessage("Depart "+depart.getDepartId()+" has been founded!");
	    }else {
	    	result.setMessage("Can not find any depart!");
	    }
	    return result;
	}

	@Override
	public ServiceResult create(Depart depart) {
		ServiceResult result = new ServiceResult();
		Depart dp = departRepository.save(depart);
		result.setData(dp);
		if(dp!=null) {
			result.setMessage("Depart "+dp.getDepartId()+" has been created!");
		}else {
			result.setMessage("Can not create any new depart!");
		}
		return result;
	}

	@Override
	public ServiceResult update(Depart depart) {
		ServiceResult result = new ServiceResult();
		if (!departRepository.findById(depart.getDepartId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Depart Not Found");
		} else {
			Depart dp = departRepository.save(depart);
			result.setData(dp);
			result.setMessage("Depart "+dp.getDepartId()+" has been updated!");
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
			result.setMessage("Depart "+depart.getDepartId()+" has been deleted!");
		}
		return result;
	}
}
