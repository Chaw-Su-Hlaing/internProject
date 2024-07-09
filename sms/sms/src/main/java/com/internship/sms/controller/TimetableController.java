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
import com.internship.sms.entity.Timetable;
import com.internship.sms.service.TimetableService;

@RestController
@RequestMapping("/timetable/")
@CrossOrigin(origins = "*")
public class TimetableController {

	@Autowired
	TimetableService timetableService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Timetable> getAll() {
		Response<Timetable> response = new Response<Timetable>();
		try {
			List<Timetable> result = timetableService.getAll();
			response.setData(result);
			response.setMessage("All Tabletable Lists");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Error Occur!");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Timetable> getById(@RequestParam Long id) {
		Response<Timetable> response = new Response<Timetable>();
		try {
			Timetable result = timetableService.getById(id);
			response.setData(result);
			response.setMessage("Timetable with Id");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error Occur!");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Response<Timetable> create(@RequestBody Timetable timetable) {
		Response<Timetable> response = new Response<Timetable>();
		try {
			Timetable result = timetableService.create(timetable);
			response.setData(result);
			response.setMessage("Save succes");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error occur!");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<Timetable> update(@RequestBody Timetable timetable) {
		Response<Timetable> response = new Response<Timetable>();
		try {
			Timetable existingData = timetableService.getById(timetable.getId());
			if (existingData != null) {
				Timetable oldData = existingData;
				oldData.setModifyDate(new Date());
				response.setData(timetableService.create(timetable));
				response.setMessage("Update succes");
			} else {
				response.setMessage("No existing data");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error Occur!");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public Response<Timetable> delete(@RequestBody Timetable timetable) {
		Response<Timetable> response = new Response<Timetable>();
		try {
			Timetable existingData = timetableService.getById(timetable.getId());
			if (existingData != null) {
				Timetable oldData = existingData;
				oldData.setActiveStatus(ActiveStatus.ACTIVE);
				oldData.setModifyDate(new Date());
				response.setData(timetableService.create(timetable));
				response.setMessage("Delete Succes");
			} else {
				response.setMessage("No existing Data");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error Occur!");
			return response;
		}
		return response;
	}
}
