/**
 * 
 */
package com.internship.sms.service;

import java.util.List;

import com.internship.sms.entity.Department;

/**
 * Thu Soe San
 */
public interface DepartmentService {
	
	public List<Department> getAllDepartment();
	
	public Department getDepartmentById(Long id);
	
	public Department create(Department dept);
	
	public Department update(Department dept);
	
	public boolean delete(Department dept);

}
