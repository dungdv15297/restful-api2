package com.emwa.service;

import com.emwa.model.Recruitment;
import com.emwa.result.ServiceResult;

public interface RecruitmentService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Recruitment recruitment);
	public ServiceResult update(Recruitment recruitment);
	public ServiceResult delete(long id);
}
