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

import com.emwa.model.Depart;
import com.emwa.result.ServiceResult;
import com.emwa.service.DepartService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/depart")
public class DepartController {
	@Autowired
	private DepartService departService;

	/* ---------------- GET ALL DEPART ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(departService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET DEPART BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(departService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW DEPART ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody Depart depart) {
		return new ResponseEntity<ServiceResult>(departService.create(depart), HttpStatus.OK);
	}

	/* ---------------- UPDATE DEPART ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody Depart depart) {
		return new ResponseEntity<ServiceResult>(departService.update(depart), HttpStatus.OK);
	}

	/* ---------------- DELETE DEPART ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(departService.delete(id), HttpStatus.OK);
	}
}
