/**
 * 
 */
package com.internship.sms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.sms.entity.Subject;
import com.internship.sms.repository.SubjectRepository;
import com.internship.sms.service.SubjectService;

/**
 * 
 */
@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAll() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long id) {
		// TODO Auto-generated method stub
		Optional<Subject> optional= subjectRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
			else
				return null;
	}

	@Override
	public Subject create(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public Subject update(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public boolean delete(Subject subject) {
		// TODO Auto-generated method stub
		try {
			subjectRepository.delete(subject);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
