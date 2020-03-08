package com.emwa.service;

import com.emwa.model.Account;
import com.emwa.result.ServiceResult;

public interface AccountService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Account account);
	public ServiceResult update(Account account);
	public ServiceResult delete(long id);
}
