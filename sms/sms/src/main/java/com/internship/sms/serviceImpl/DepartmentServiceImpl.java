/**
 * 
 */
package com.internship.sms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.sms.entity.Department;
import com.internship.sms.repository.DepartmentRepository;
import com.internship.sms.service.DepartmentService;

/**
 * Thu Soe San
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		Optional<Department> optional =departmentRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else 
			return null;
		}

	@Override
	public Department create(Department dept) {
		// TODO Auto-generated method stub
		return departmentRepository.save(dept);
	}

	@Override
	public Department update(Department dept) {
		// TODO Auto-generated method stub
		return departmentRepository.save(dept);
	}

	@Override
	public boolean delete(Department dept) {
		try {
			departmentRepository.delete(dept);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

}
