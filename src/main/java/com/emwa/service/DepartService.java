package com.emwa.service;

import org.springframework.stereotype.Service;

import com.emwa.model.Depart;
import com.emwa.result.ServiceResult;
@Service
public interface DepartService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Depart depart);
	public ServiceResult update(Depart depart);
	public ServiceResult delete(long id);
}
