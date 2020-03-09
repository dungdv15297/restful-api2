package com.emwa.service;

import org.springframework.stereotype.Service;

import com.emwa.model.Account;
import com.emwa.result.ServiceResult;
@Service
public interface AccountService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Account account);
	public ServiceResult update(Account account);
	public ServiceResult delete(long id);
}
