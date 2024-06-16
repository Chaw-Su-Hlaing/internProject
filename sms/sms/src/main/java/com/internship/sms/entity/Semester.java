package com.internship.sms.entity;

import java.io.Serializable;

import jakarta.persistence.Column;

/**
 * Thu Soe San
 */
public class Semester extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -373313639936416956L;
	
	@Column(name="name")
	private String semesterName;
	
	@Column(name="start_date")
	private String semStartDate;
	
	@Column (name="end_date")
	private String semEndDate;

}
