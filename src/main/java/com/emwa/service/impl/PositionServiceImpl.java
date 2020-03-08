package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emwa.model.Position;
import com.emwa.repository.PositionRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.PositionService;

public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionRepository positionRepository;
	
	@Override
	public ServiceResult findAll() {
		ServiceResult result = new ServiceResult();
		result.setData(positionRepository.findAll());
		return result;
	}

	@Override
	public ServiceResult findById(long id) {
		ServiceResult result = new ServiceResult();
	    Position position = positionRepository.findById(id).orElse(null);
	    result.setData(position);
	    return result;
	}

	@Override
	public ServiceResult create(Position position) {
		ServiceResult result = new ServiceResult();
		result.setData(positionRepository.save(position));
		return result;
	}

	@Override
	public ServiceResult update(Position position) {
		ServiceResult result = new ServiceResult();
		if (!positionRepository.findById(position.getPositionId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Position Not Found");
		} else {
			result.setData(positionRepository.save(position));
		}
		return result;
	}

	@Override
	public ServiceResult delete(long id) {
		ServiceResult result = new ServiceResult();
		Position position = positionRepository.findById(id).orElse(null);
		if (position == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Position Not Found");
		} else {
			positionRepository.delete(position);
			result.setMessage("Delete Success");
		}
		return result;
	}
}
