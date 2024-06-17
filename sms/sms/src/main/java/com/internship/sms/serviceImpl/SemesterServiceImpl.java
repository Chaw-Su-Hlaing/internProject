
/**
 * 
 */
package com.internship.sms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.sms.entity.Semester;
import com.internship.sms.repository.SemesterRepository;
import com.internship.sms.service.SemesterService;

/**
 * Thu Soe San
 */
@Service
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	SemesterRepository SemesterRepository;

	@Override
	public List<Semester> getAllSemester() {
		// TODO Auto-generated method stub
		return SemesterRepository.findAll();
	}

	@Override
	public Semester create(Semester year) {
		// TODO Auto-generated method stub
		return SemesterRepository.save(year);
	}

	@Override
	public Semester update(Semester year) {
		// TODO Auto-generated method stub
		return SemesterRepository.save(year);
	}

	@Override
	public boolean delete(Semester year) {
		// TODO Auto-generated method stub
		try {
			SemesterRepository.delete(year);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public Semester getSemesterById(Long id) {
		// TODO Auto-generated method stub
		Optional<Semester> optional = SemesterRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

}
