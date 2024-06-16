/**
 * 
 */
package com.internship.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internship.sms.common.Response;
import com.internship.sms.entity.Position;
import com.internship.sms.service.PositionService;

/**
 * 
 */
@RestController
@RequestMapping("/position/")
@CrossOrigin(origins = "*")
public class PositionController {
	@Autowired
	PositionService positionService;

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public Response<Position> getById(@RequestParam Long id) {
		Response<Position> response = new Response<Position>();
		try {
			Position result = positionService.getPositionById(id);
			response.setMessage("All position lists");
			response.setData(result);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Error Occur");
			return response;
		}
		return response;
	}


}
