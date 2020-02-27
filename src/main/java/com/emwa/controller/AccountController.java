package com.emwa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emwa.exception.ResourceNotFoundException;
import com.emwa.model.Account;
import com.emwa.model.Staff;
import com.emwa.repository.AccountRepository;


@RestController
@RequestMapping("api/v1")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@GetMapping("accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long accountId)
			throws ResourceNotFoundException {
		
		Account Account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Nhân viên này không tồn tại: " + accountId));
		
		return ResponseEntity.ok().body(Account);
	}

	@PostMapping("accounts")
	public Account createAccount(@Valid @RequestBody Account Account) {
		return accountRepository.save(Account);
	}

	@PutMapping("accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Long accountId,
			@Valid @RequestBody Account accountDetails) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Nhân viên này không tồn tại: " + accountId));
		account.setStaff(accountDetails.getStaff());
		account.setUsername(accountDetails.getUsername());
		account.setPassword(accountDetails.getPassword());
		account.setCreateDate(accountDetails.getCreateDate());
		account.setRole(accountDetails.getRole());
		
		final Account updatedAccount = accountRepository.save(account);
		
		return ResponseEntity.ok(updatedAccount);
	}

	@DeleteMapping("/accounts/{id}")
	public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId)
			throws ResourceNotFoundException {
		
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Nhân viên này không tồn tại: " + accountId));

		accountRepository.delete(account);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}