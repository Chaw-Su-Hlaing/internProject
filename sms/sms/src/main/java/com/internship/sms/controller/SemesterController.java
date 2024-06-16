package com.internship.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.internship.sms.common.Response;
import com.internship.sms.entity.Semester;
import com.internship.sms.service.SemesterService;

public class SemesterController {
	@Autowired
	SemesterService semesterService;
	
	@RequestMapping(value="getAll",method = RequestMethod.GET)
	public Response<Semester> getAll(@RequestBody Semester semester){
		Response<Semester> response = new Response<Semester>();
		try {
			List<Semester> result=semesterService.getAllSemester();
			response.setData(result);
			response.setMessage("All semester list");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}return response;
	}

}
