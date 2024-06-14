/**
 * 
 */
package com.internship.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internship.sms.common.Response;
import com.internship.sms.entity.Department;
import com.internship.sms.service.DepartmentService;

/**
 * Thu Soe San
 */
@RestController
@RequestMapping("/dept/")
@CrossOrigin(origins = "*")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Department> getById(@RequestParam Long id) {
		Response<Department> response = new Response<Department>();
		try {
			Department result = departmentService.getDepartmentById(id);
			response.setMessage("All Department lists");
			response.setData(result);
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Department> getAll() {
		Response<Department> response = new Response<Department>();
		try {
			List<Department> result = departmentService.getAll();
			response.setMessage("All Department lists");
			response.setData(result);
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occur");
			return response;
		}
		return response;
	}

	
	
	
}
