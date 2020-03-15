package com.emwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emwa.model.Account;
import com.emwa.result.ServiceResult;
import com.emwa.service.AccountService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	/* ---------------- GET ALL ACCOUNT ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAllCustomer() {
		return new ResponseEntity<ServiceResult>(accountService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET ACCOUNT BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(accountService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW ACCOUNT ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody Account account) {
		return new ResponseEntity<ServiceResult>(accountService.create(account), HttpStatus.OK);
	}

	/* ---------------- UPDATE ACCOUNT ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody Account account) {
		return new ResponseEntity<ServiceResult>(accountService.update(account), HttpStatus.OK);
	}

	/* ---------------- DELETE ACCOUNT ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(accountService.delete(id), HttpStatus.OK);
	}

}