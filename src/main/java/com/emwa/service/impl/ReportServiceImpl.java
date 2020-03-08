package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emwa.model.Account;
import com.emwa.model.Report;
import com.emwa.repository.ReportRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.ReportService;

public class ReportServiceImpl implements ReportService {
	@Autowired
	ReportRepository reportRepository;

	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(reportRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
		Report report = reportRepository.findById(id).orElse(null);
		result.setData(report);
		return result;
	}

	@Override
	public ServiceResult create(Report report) {
		ServiceResult result = new ServiceResult();
		result.setData(reportRepository.save(report));
		return result;
	}

	@Override
	public ServiceResult update(Report report) {
		ServiceResult result = new ServiceResult();
		if (!reportRepository.findById(report.getReportId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Account Not Found");
		} else {
			result.setData(reportRepository.save(report));
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		Report report = reportRepository.findById(id).orElse(null);
		if (report == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Report Not Found");
		} else {
			reportRepository.delete(report);
			result.setMessage("Delete Success");
		}
		return result;
	}
}
