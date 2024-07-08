package com.internship.sms.entity;

import java.io.Serializable;
import java.security.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="schedule")
public class Schedule extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="from_time")
	private Timestamp fromTime;
	
	@Column(name="to_date")
	private Timestamp toDate;
	
	@Column(name="Day")
	private String scheduleDay;

}
