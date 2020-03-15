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

import com.emwa.model.Recruitment;
import com.emwa.result.ServiceResult;
import com.emwa.service.RecruitmentService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/recruitment")
public class RecruitmentController {
	@Autowired
	private RecruitmentService recruitmentService;

	/* ---------------- GET ALL RECRUITMENT ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAllCustomer() {
		return new ResponseEntity<ServiceResult>(recruitmentService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET RECRUITMENT BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(recruitmentService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW RECRUITMENT ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody Recruitment recruitment) {
		return new ResponseEntity<ServiceResult>(recruitmentService.create(recruitment), HttpStatus.OK);
	}

	/* ---------------- UPDATE RECRUITMENT ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody Recruitment recruitment) {
		return new ResponseEntity<ServiceResult>(recruitmentService.update(recruitment), HttpStatus.OK);
	}

	/* ---------------- DELETE RECRUITMENT ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(recruitmentService.delete(id), HttpStatus.OK);
	}
}
