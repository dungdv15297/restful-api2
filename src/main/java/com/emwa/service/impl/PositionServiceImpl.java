package com.emwa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emwa.model.Position;
import com.emwa.repository.PositionRepository;
import com.emwa.result.ServiceResult;
import com.emwa.result.ServiceResult.Status;
import com.emwa.service.PositionService;
@Service
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
	    if(position!=null) {
	    	result.setMessage("Position "+position.getPositionId()+" has been founded!");
	    }else {
	    	result.setMessage("Can not find any positions!");
	    }
	    return result;
	}

	@Override
	public ServiceResult create(Position position) {
		ServiceResult result = new ServiceResult();
		Position pst = positionRepository.save(position);
		result.setData(pst);
		if( pst != null) {
			result.setMessage("Position "+pst.getPositionId()+" has been created!");
		}else {
			result.setMessage("Can not create any new positions!");
		}
		return result;
	}

	@Override
	public ServiceResult update(Position position) {
		ServiceResult result = new ServiceResult();
		if (!positionRepository.findById(position.getPositionId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Position Not Found");
		} else {
			Position pst = positionRepository.save(position);
			result.setData(pst);
			result.setMessage("Position "+pst.getPositionId()+" has been updated!");
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
			result.setMessage("Position "+position.getPositionId()+" has been deleted!");
		}
		return result;
	}
}
