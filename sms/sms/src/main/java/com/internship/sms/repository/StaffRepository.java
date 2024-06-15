package com.internship.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.sms.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
	
	

}
