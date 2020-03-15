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

import com.emwa.model.Staff;
import com.emwa.result.ServiceResult;
import com.emwa.service.StaffService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
	@Autowired
	private StaffService staffService;

	/* ---------------- GET ALL STAFF ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(staffService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET STAFF BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(staffService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW STAFF ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody Staff staff) {
		return new ResponseEntity<ServiceResult>(staffService.create(staff), HttpStatus.OK);
	}

	/* ---------------- UPDATE STAFF ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody Staff staff) {
		return new ResponseEntity<ServiceResult>(staffService.update(staff), HttpStatus.OK);
	}

	/* ---------------- DELETE STAFF ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(staffService.delete(id), HttpStatus.OK);
	}
}
