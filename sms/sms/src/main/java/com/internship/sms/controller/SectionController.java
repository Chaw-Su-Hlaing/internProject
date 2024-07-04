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
import com.internship.sms.entity.Section;
import com.internship.sms.service.SectionService;

@RestController
@RequestMapping("/section/")
@CrossOrigin(origins = "*")
public class SectionController {

	@Autowired
	SectionService sectionService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Section> getAllSection() {
		Response<Section> response = new Response<Section>();
		try {
			List<Section> result = sectionService.getAllSection();
			response.setData(result);
			response.setMessage("All Section Lists");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal error occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Section> getSectionById(@RequestParam Long id) {
		Response<Section> response = new Response<Section>();
		try {
			Section result = sectionService.getSectionById(id);
			response.setData(result);
			response.setMessage("Section with id");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("internal server error occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public Response<Section> save(@RequestBody Section section) {
		Response<Section> response = new Response<Section>();
		try {
			Section result = sectionService.create(section);
			response.setData(result);
			response.setMessage("save success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("internal server error occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<Section> update(@RequestParam Section section) {
		Response<Section> response = new Response<Section>();
		try {
			Section existingData = sectionService.getSectionById(section.getId());
			if (existingData != null) {
				Section oldData = existingData;
				oldData.setModifyDate(new Date());
				response.setData(sectionService.create(oldData));
				response.setMessage("Update succes");
			} else {
				response.setMessage("No Existing Data");
			}
		} catch (Exception e) {
			// TODO: handle
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public Response<Section> delete(@RequestBody Section section) {
		Response<Section> response = new Response<Section>();
		try {
			Section existingData = sectionService.getSectionById(section.getId());
			if (existingData != null) {
				Section oldData = existingData;
				oldData.setActiveStatus(ActiveStatus.DELETE);
				oldData.setModifyDate(new Date());
				response.setData(sectionService.create(oldData));
				response.setMessage("delete sucess");
			} else {
				response.setMessage("No existing data");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("internal server error occur");
			return response;
		}
		return response;
	}
}