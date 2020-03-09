package com.emwa.service;

import org.springframework.stereotype.Service;

import com.emwa.model.Recruitment;
import com.emwa.result.ServiceResult;
@Service
public interface RecruitmentService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Recruitment recruitment);
	public ServiceResult update(Recruitment recruitment);
	public ServiceResult delete(long id);
}
