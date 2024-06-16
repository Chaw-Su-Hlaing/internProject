/**
 * 
 */
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
import com.internship.sms.entity.Subject;
import com.internship.sms.repository.SubjectRepository;
import com.internship.sms.service.SubjectService;

/**
 * 
 */
@RestController
@RequestMapping("/subject/")
@CrossOrigin(origins = "*")
public class SubjectController {
	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Subject> getById(@RequestParam Long id) {
		Response<Subject> response = new Response<Subject>();
		try {
			Subject result = subjectService.getSubjectById(id);
			response.setMessage("All Subject Lists");
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
	public Response<Subject> getAll() {
		Response<Subject> response = new Response<Subject>();
		try {
			List<Subject> result = subjectService.getAll();
			response.setMessage("All Subject Lists");
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
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public Response<Subject> create(@RequestBody Subject subject){
		Response<Subject> response=new Response<Subject>();
		try {
			subjectService.create(subject);
		response.setData("Success");	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occurs");
			return response;
		}
		return response;
	}

	@RequestMapping(value="update",method=RequestMethod.POST)
	public Response<Subject> update(@RequestBody Subject subject){
		Response<Subject> response=new Response<Subject>();
	
		try {
			Subject existingData= subjectService.getSubjectById(subject.getId());
			if(existingData!=null) {
				Subject oldData= existingData;
				oldData = subject;
				response.setData(subjectService.create(oldData));
				response.setMessage("Update Success");
			}else
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
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public Response<Subject> delete(@RequestParam Long subjectId){
		Response<Subject> response=new Response<Subject>();
	
		try {
			Subject existingData= subjectService.getSubjectById(subjectId);
			if(existingData!=null) {
				Subject oldData= existingData;
				oldData.setActiveStatus(ActiveStatus.DELETE);
				oldData.setModifyDate(new Date());
				response.setData(subjectService.create(oldData));
				response.setMessage("Delete Success");
			}else
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
