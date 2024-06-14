/**
 * 
 */
package com.internship.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internship.demo.common.Response;
import com.internship.sms.entity.Department;
import com.internship.sms.service.DepartmentService;

/**
 * Thu Soe San
 */
@RestController
@RequestMapping("/dept")
@CrossOrigin(origins="*")
public class DepartmentController {
	
	@Autowired 
	DepartmentService departmentService;
	
	@GetMapping(value="getById")
	public Response<Department> getById(@RequestParam Long id){
	Response<Department> response= new Response<Department>();
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	

}
