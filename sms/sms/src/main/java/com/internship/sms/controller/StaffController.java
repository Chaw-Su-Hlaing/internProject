package com.internship.sms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.internship.sms.common.ActiveStatus;
import com.internship.sms.common.Response;
import com.internship.sms.common.Util;
import com.internship.sms.entity.Staff;
import com.internship.sms.service.StaffService;

@RestController
@RequestMapping("/staff/")
@CrossOrigin(origins = "*")
public class StaffController {

	@Value("${staff.file.path.realPath}")
	private String staffRealPath;

	@Value("${staff.file.path.relativePath}")
	private String staffRelativePath;

	@Value("${staff.file.path.defaultPath}")
	private String defaultStaffPhoto;

	@Autowired
	StaffService staffService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Staff> getAl() {
		Response<Staff> response = new Response<Staff>();

		try {
			List<Staff> result = staffService.getAllStaff();
			response.setData(result);
			response.setMessage("All Staff List");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Staff> getById(@RequestParam Long id) {
		Response<Staff> response = new Response<>();
		try {
			Staff result = staffService.getStaffById(id);
			response.setData(result);
			response.setMessage("Saff");
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;

			// TODO: handle exception
		}
		return response;
	}

	@RequestMapping(value = "uploadStaffFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public Response<String> saveStaffFile(@RequestPart("uploadFile") MultipartFile uploadFile) throws IOException {
		Response<String> response = new Response<String>();

		if (uploadFile == null || uploadFile.isEmpty()) {
			response.setStatus(false);
			response.setMessage("Invalid file upload");
		} else {
			String filePath = Util.uploadFile(uploadFile, staffRealPath, staffRelativePath);
			response.setData(filePath);
		}
		return response;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Response<Staff> create(@RequestBody Staff staff) {
		Response<Staff> response = new Response<>();
		try {
			if (staff.getStaffProfilePicture() == null)
				staff.setStaffProfilePicture(defaultStaffPhoto);

			Staff result = staffService.create(staff);
			response.setData(result);
			response.setMessage("create success)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;

		}
		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<Staff> update(@RequestBody Staff staff) {
		Response<Staff> response = new Response<>();
		try {
			Staff existingData = staffService.getStaffById(staff.getId());
			if (existingData != null) {
				Staff oldData = new Staff();
				oldData = staff;
				oldData.setModifyDate(new Date());
				response.setData(staffService.create(oldData));
				response.setMessage("Update success");
			} else {
				response.setMessage("No existing data");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server occur");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public Response<Staff> delete(@RequestParam Long id) {
		Response<Staff> response = new Response<Staff>();
		try {
			Staff existingData = staffService.getStaffById(id);
			if (existingData != null) {
				Staff oldData = existingData;
				oldData = existingData;
				oldData.setActiveStatus(ActiveStatus.DELETE);
				oldData.setModifyDate(new Date());

				response.setData(staffService.create(oldData));
				response.setMessage("Delete success");
			} else {
				response.setMessage("No existing data");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server occur");
			return response;
			// TODO: handle exception
		}
		return response;

	}
}
