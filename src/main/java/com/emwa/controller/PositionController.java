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

import com.emwa.model.Position;
import com.emwa.result.ServiceResult;
import com.emwa.service.PositionService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/position")
public class PositionController {
	@Autowired
	private PositionService positionService;

	/* ---------------- GET ALL POSITION ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(positionService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET POSITION BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(positionService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW POSITION ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody Position position) {
		return new ResponseEntity<ServiceResult>(positionService.create(position), HttpStatus.OK);
	}

	/* ---------------- UPDATE POSITION ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody Position position) {
		return new ResponseEntity<ServiceResult>(positionService.update(position), HttpStatus.OK);
	}

	/* ---------------- DELETE POSITION ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(positionService.delete(id), HttpStatus.OK);
	}
}
