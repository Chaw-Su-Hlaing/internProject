package com.internship.sms.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.internship.sms.entity.Staff;
import com.internship.sms.repository.StaffRepository;
import com.internship.sms.service.StaffService;


public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffRepository staffRepository;

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffById(Long id) {
		// TODO Auto-generated method stub
		Optional<Staff> optional=staffRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
			
		} else {
				return null;
		}
		
	}

	@Override
	public Staff create(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
	}

	@Override
	public Staff update(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
	}

	@Override
	public boolean delete(Staff staff) {
		// TODO Auto-generated method stub
		
			try {
				staffRepository.delete(staff);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
	}

}
