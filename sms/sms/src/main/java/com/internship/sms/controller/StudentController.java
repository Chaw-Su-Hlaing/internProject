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
import com.internship.sms.entity.User;
import com.internship.sms.service.StudentService;
import com.internship.sms.service.UserService;

@RestController
@RequestMapping("/student/")
@CrossOrigin(origins = "*")
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Student> getById(@RequestParam Long id) {
		Response<Student> response = new Response<Student>();
		try {
			Student result = studentservice.getStudentById(id);
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
			List<Student> result = studentservice.getAll();
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
			/*
			 * if(student.getStu_pp()== null) student.setStu_pp(defaultStaffPhoto);
			 */
			Student result = studentservice.create(student);
			if (!result.getStu_email().isEmpty()) {
				User user = new User();
				user.setUserName((result.getStu_gender().equals("Male") ? "Mg " : "Ma " )+ result.getStu_name());
				user.setEmail(result.getStu_email());
				user.setPassword("P@ssw0rd");
				user.setRole("STUDENT");
				
				userService.createUser(user);
				
			}
			
			response.setData(result);
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
			Student existingData = studentservice.getStudentById(student.getId());
			if (existingData != null) {
				student.setModifyDate(new Date());				
				if (!student.getStu_email().isEmpty()) {
					User user = userService.findByEmail(existingData.getStu_email());
					if(user != null) {
						if(user.getEmail().equals(student.getStu_email())) {
							user.setUserName((student.getStu_gender().equals("Male") ? "Mg " : "Ma ") + student.getStu_name());
							
						}else {
							user.setUserName((student.getStu_gender().equals("Male") ? "Mg " : "Ma ") + student.getStu_name());
							user.setEmail(student.getStu_email());
						}
					}else {
						user = new User();
						user.setUserName((student.getStu_gender().equals("Male") ? "Mg " : "Ma ") + student.getStu_name());
						user.setEmail(student.getStu_email());
						user.setPassword("P@ssw0rd");
						user.setRole("STUDENT");
					}				
					userService.createUser(user);
				}
				studentservice.create(student);
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
			Student existingData = studentservice.getStudentById(id);
			if (existingData != null) {
				Student oldData = existingData;
				oldData.setActiveStatus(ActiveStatus.DELETE);
				oldData.setModifyDate(new Date());
				response.setData(studentservice.create(oldData));
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
