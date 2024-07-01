/**
 * 
 */
package com.internship.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.internship.sms.common.Response;
import com.internship.sms.entity.Student;
import com.internship.sms.entity.User;
import com.internship.sms.service.StudentService;
import com.internship.sms.service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/login/")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	public Response<User> checkUser(@RequestBody User usr) {
		Response<User> response = new Response<User>();
		try {
			User checkUser = userService.checkUser(usr.getUserName(), usr.getPassword());
			if (checkUser != null) {
				User user = new User();
				user.setUserName(checkUser.getUserName());
				user.setEmail(checkUser.getEmail());
				user.setRole(checkUser.getRole());
				switch (user.getRole()) {
				case "STUDENT":
					Student student = studentService.getStudentInfoByEmail(user.getEmail());
					if (student != null)
						user.setUserProfile(student.getStu_pp());
					break;
				case "TEACHER":
					break;
				case "ADMIN":
					break;
				}
				response.setData(user);
			} else {
				response.setStatus(false);
				response.setMessage("Invalid user account");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}
		return response;
	}

}
