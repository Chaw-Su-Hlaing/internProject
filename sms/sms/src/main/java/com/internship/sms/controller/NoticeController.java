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
import com.internship.sms.entity.Notice;
import com.internship.sms.service.NoticeService;

@RestController
@RequestMapping("/notice/")
@CrossOrigin(origins = "*")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Notice> getAll() {
		Response<Notice> response = new Response<Notice>();
		try {
			List<Notice> result = noticeService.getAll();
			response.setData(result);
			response.setMessage("All Notice Lists");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getAllByNoticeStatus", method = RequestMethod.GET)
	public Response<Notice> getAllByNoticeStatus() {
		Response<Notice> response = new Response<Notice>();
		try {
			List<Notice> result = noticeService.getAllByNoticeStatus();
			response.setData(result);
			response.setMessage("All unread Notice Lists");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Notice> getById(@RequestParam Long id) {
		Response<Notice> response = new Response<Notice>();
		try {
			Notice result = noticeService.getById(id);
			response.setData(result);
			response.setMessage("Notice with Selected Id");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Response<Notice> create(@RequestBody Notice notice) {
		Response<Notice> response = new Response<Notice>();
		try {
			notice.setNotice_status(true);
			Notice result = noticeService.create(notice);
			response.setData(result);
			response.setMessage("Save succes");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal Server Error");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public Response<Notice> delete(@RequestParam Long id) {
		Response<Notice> response = new Response<Notice>();
		try {
			Notice existingData = noticeService.getById(id);
			if (existingData != null) {
				Notice oldData = existingData;
				oldData.setActiveStatus(ActiveStatus.DELETE);
				oldData.setModifyDate(new Date());
				response.setData(noticeService.create(oldData));
				response.setMessage("Delete succes");
			} else {
				response.setMessage("Record Not Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<Notice> update(@RequestBody Notice notice) {
		Response<Notice> response = new Response<Notice>();
		try {
			Notice existingData = noticeService.getById(notice.getId());
			if (existingData != null) {
				Notice oldData = notice;
				oldData.setNotice_status(false);
				response.setData(noticeService.create(oldData));
				response.setMessage("update succes");
			} else {
				response.setMessage("NO existing Data");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error occur");
			return response;
		}
		return response;
	}
}
