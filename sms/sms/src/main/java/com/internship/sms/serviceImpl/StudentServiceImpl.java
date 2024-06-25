package com.internship.sms.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.sms.common.ActiveStatus;
import com.internship.sms.entity.Student;
import com.internship.sms.repository.StudentRepository;
import com.internship.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentrepository;

	@Override
	
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentrepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
		return null;
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}

	@Override
	public boolean delete(Student student) {
		// TODO Auto-generated method stub

		try {
			studentrepository.delete(student);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentrepository.getAllByActiveStatus(ActiveStatus.ACTIVE);
	}

}
