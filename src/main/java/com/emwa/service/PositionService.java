package com.emwa.service;

import com.emwa.model.Position;
import com.emwa.result.ServiceResult;

public interface PositionService {
	public ServiceResult findAll();
	public ServiceResult findById(long id);
	public ServiceResult create(Position position);
	public ServiceResult update(Position position);
	public ServiceResult delete(long id);
}
