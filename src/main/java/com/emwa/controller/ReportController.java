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

import com.emwa.model.Report;
import com.emwa.result.ServiceResult;
import com.emwa.service.ReportService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/report")
public class ReportController {
	@Autowired
	private ReportService reportService;

	/* ---------------- GET ALL REPORT ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(reportService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET REPORT BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(reportService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW REPORT ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody Report report) {
		return new ResponseEntity<ServiceResult>(reportService.create(report), HttpStatus.OK);
	}

	/* ---------------- UPDATE REPORT ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody Report report) {
		return new ResponseEntity<ServiceResult>(reportService.update(report), HttpStatus.OK);
	}

	/* ---------------- DELETE REPORT ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(reportService.delete(id), HttpStatus.OK);
	}
}
