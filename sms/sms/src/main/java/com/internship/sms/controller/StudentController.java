package com.internship.sms.controller;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internship.sms.common.ActiveStatus;
import com.internship.sms.common.Response;
import com.internship.sms.entity.Student;
import com.internship.sms.service.StudentService;

@RestController
@RequestMapping("/student/")
@CrossOrigin(origins = "*")
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Student> getById(@RequestParam Long id) {
		Response<Student> response = new Response<Student>();
		try {
			Student result = service.getStudentById(id);
			response.setMessage("All Student Lists");
			response.setData(result);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occurs");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Student> getAll() {
		Response<Student> response = new Response<Student>();
		try {
			List<Student> result =service.getAll();
			response.setMessage("All Student Lists");
			response.setData(result);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occurs");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Response<Student> create(@RequestBody Student student) {
		Response<Student> response = new Response<Student>();
		try {
			response.setData(service.create(student));
			response.setMessage("Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occurs");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<Student> update(@RequestBody Student student) {
		Response<Student> response = new Response<Student>();

		try {
			Student existingData = service.getStudentById(student.getId());
			if (existingData != null) {
				Student oldData = existingData;
				oldData = student;
				response.setData(service.create(oldData));
				response.setMessage("Update Success");
			} else
				response.setMessage("No existing data");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public Response<Student> delete(@RequestParam Long id) {
		Response<Student> response = new Response<Student>();

		try {
			Student existingData = service.getStudentById(id);
			if (existingData != null) {
				Student oldData = existingData;
				oldData.setActiveStatus(ActiveStatus.DELETE);
				oldData.setModifyDate(new Date());
				response.setData(service.create(oldData));
				response.setMessage("Delete Success");
			} else
				response.setMessage("No existing data");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error occur");
			return response;
		}
		return response;
	}
}
