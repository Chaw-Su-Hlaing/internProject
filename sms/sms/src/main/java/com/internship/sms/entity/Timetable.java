package com.internship.sms.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "timetable")
public class Timetable extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private Schedule scheduleTime;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@Column(name="teacher_id")
	private String teacher_id;
	
	@ManyToOne
	@JoinColumn(name="year_id")
	private AcademicYear acdemicYear;
	
	
	
	
	
	

}
