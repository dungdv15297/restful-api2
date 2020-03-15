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

import com.emwa.model.LeaveRequest;
import com.emwa.result.ServiceResult;
import com.emwa.service.LeaveRequestService;
@CrossOrigin
@RestController
@RequestMapping("api/v1/leave")
public class LeaveRequestController {
	@Autowired
	private LeaveRequestService leaveRequestService;

	/* ---------------- GET ALL LEAVE_REQUEST ------------------------ */
	@GetMapping()
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(leaveRequestService.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET LEAVE_REQUEST BY ID ------------------------ */
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable long id) {
		return new ResponseEntity<ServiceResult>(leaveRequestService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW LEAVE_REQUEST ------------------------ */
	@PostMapping()
	public ResponseEntity<ServiceResult> create(@RequestBody LeaveRequest leaveRequest) {
		return new ResponseEntity<ServiceResult>(leaveRequestService.create(leaveRequest), HttpStatus.OK);
	}

	/* ---------------- UPDATE LEAVE_REQUEST ------------------------ */
	@PutMapping()
	public ResponseEntity<ServiceResult> update(@RequestBody LeaveRequest leaveRequest) {
		return new ResponseEntity<ServiceResult>(leaveRequestService.update(leaveRequest), HttpStatus.OK);
	}

	/* ---------------- DELETE LEAVE_REQUEST ------------------------ */
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable Long id) {
		return new ResponseEntity<ServiceResult>(leaveRequestService.delete(id), HttpStatus.OK);
	}
}
