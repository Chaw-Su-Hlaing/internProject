/**
 * 
 */
package com.internship.sms.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Thu Soe San
 */
@Getter
@Setter
@Entity
@Table(name="Student")
public class Student  extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -5775636371997320818L;
	
	@Column(name="student_name")
	private String stu_name;
	

	@Column(name="student_email")
	private String stu_email;
	

	@Column(name="student_phone")
	private String phone_no;
	

	@Column(name="student_currentAdd")
	private String stu_currAddress;

	@Column(name="student_HomeAdd")
	private String stu_homeAdd;

	@Column(name="student_gender")
	private String stu_gender;
	
	@Column(name="student_DOB")
	private Date stu_dob;
	

	@Column(name="student_Nrc")
	private String stu_nrc;

	@Column(name="student_profile")
	private String stu_pp;

	@Column(name="student_national")
	private String stu_national;

	@Column(name="student_Religion")
	private String stu_religion;

	@Column(name="student_relationStatus")
	private String stu_relationshipStat;

	@Column(name="student_hostel")
	private String stu_hostel;

	@Column(name="student_ferry")
	private String stu_ferry;
}
