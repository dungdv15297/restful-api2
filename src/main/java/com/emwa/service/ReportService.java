package com.emwa.service;

import org.springframework.stereotype.Service;

import com.emwa.model.Report;
import com.emwa.result.ServiceResult;
@Service
public interface ReportService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Report report);
	public ServiceResult update(Report report);
	public ServiceResult delete(long id);
}
