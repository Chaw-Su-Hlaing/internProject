/**
 * 
 */
package com.internship.sms.controller;

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

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Department> getById(@RequestParam Long id) {
		Response<Department> response = new Response<Department>();
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

}
