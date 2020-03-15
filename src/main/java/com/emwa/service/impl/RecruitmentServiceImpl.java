package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emwa.model.Depart;
import com.emwa.model.Recruitment;
import com.emwa.repository.RecruitmentRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.RecruitmentService;
@Service
public class RecruitmentServiceImpl implements RecruitmentService {
	@Autowired
	RecruitmentRepository recruitmentRepository;
	
	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(recruitmentRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
		Recruitment recruitment = recruitmentRepository.findById(id).orElse(null);
	    result.setData(recruitment);
	    if(recruitment!=null) {
	    	result.setMessage("Recruitment "+recruitment.getRecruitmentId()+" has been founded!");
	    }else {
	    	result.setMessage("Can not find any recruitment!");
	    }
	    return result;
	}

	@Override
	public ServiceResult create(Recruitment recruitment) {
		ServiceResult result = new ServiceResult();
		Recruitment rcr = recruitmentRepository.save(recruitment);
		result.setData(rcr);
		if(rcr!=null) {
			result.setMessage("Recruitment "+rcr.getRecruitmentId()+" has been created!");
		}else {
			result.setMessage("Can not create any new recruitment!");
		}
		return result;
	}

	@Override
	public ServiceResult update(Recruitment recruitment) {
		ServiceResult result = new ServiceResult();
		if (!recruitmentRepository.findById(recruitment.getRecruitmentId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Recruitment Not Found");
		} else {
			Recruitment rcr = recruitmentRepository.save(recruitment);
			result.setData(rcr);
			result.setMessage("Recruitment "+rcr.getRecruitmentId()+" has been updated!");
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		Recruitment recruitment = recruitmentRepository.findById(id).orElse(null);
		if (recruitment == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Recruitment Not Found");
		} else {
			recruitmentRepository.delete(recruitment);
			result.setMessage("Recruitment "+recruitment.getRecruitmentId()+" has been deleted!");
		}
		return result;
	}
}
