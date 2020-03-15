package com.emwa.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emwa.model.Account;
import com.emwa.repository.AccountRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(accountRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
	    Account account = accountRepository.findById(id).orElse(null);
	    result.setData(account);
	    if(account!=null) {
	    	result.setMessage("Account "+account.getAccountId()+" has been founded!");
	    }else {
	    	result.setMessage("Can not find any account!");
	    }
	    return result;
	}

	@Override
	public ServiceResult create(Account account) {
		ServiceResult result = new ServiceResult();
		Account acc = accountRepository.save(account);
		result.setData(acc);
		if(acc != null) {
			result.setMessage("Account "+acc.getAccountId()+" has been created!");
		}else {
			result.setMessage("Can not create any new account!");
		}
		return result;
	}

	@Override
	public ServiceResult update(Account account) {
		ServiceResult result = new ServiceResult();
		if (!accountRepository.findById(account.getAccountId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Account Not Found");
		} else {
			Account acc = accountRepository.save(account);
			result.setData(acc);
			result.setMessage("Account "+acc.getAccountId()+" has been updated!");
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		Account account = accountRepository.findById(id).orElse(null);
		if (account == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Account Not Found");
		} else {
			accountRepository.delete(account);
			result.setMessage("Account "+account.getAccountId()+" has been deleted!");
		}
		return result;
	}
}
