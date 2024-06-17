/**
 * 
 */
package com.internship.sms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.sms.entity.Position;
import com.internship.sms.repository.PositionRepository;
import com.internship.sms.service.PositionService;

/**
 * 
 */
@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionRepository positionRepository;

	@Override
	public List<Position> getAll() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position getPositionById(Long id) {
		// TODO Auto-generated method stub
		Optional<Position> optional= positionRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Override
	public Position create(Position position) {
		// TODO Auto-generated method stub
		return positionRepository.save(position);
	}

	@Override
	public Position update(Position position) {
		// TODO Auto-generated method stub
		return positionRepository.save(position);
	}

	@Override
	public boolean delete(Position position) {
		// TODO Auto-generated method stub
		try {
			positionRepository.delete(position);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	

}