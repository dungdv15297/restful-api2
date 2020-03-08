package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emwa.model.Recruitment;
import com.emwa.repository.RecruitmentRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.RecruitmentService;

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
	    return result;
	}

	@Override
	public ServiceResult create(Recruitment recruitment) {
		ServiceResult result = new ServiceResult();
		result.setData(recruitmentRepository.save(recruitment));
		return result;
	}

	@Override
	public ServiceResult update(Recruitment recruitment) {
		ServiceResult result = new ServiceResult();
		if (!recruitmentRepository.findById(recruitment.getRecruitmentId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Recruitment Not Found");
		} else {
			result.setData(recruitmentRepository.save(recruitment));
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
			result.setMessage("Delete Success");
		}
		return result;
	}
}
