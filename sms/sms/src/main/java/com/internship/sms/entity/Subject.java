/**
 * 
 */
package com.internship.sms.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Thu Soe San
 */

@Getter
@Setter
@Entity
@Table(name="subject")

public class Subject extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7914523810039664448L;

	@Column(name="subject_name")
	private String name;
	
	@Column(name="module_no")
	private String moduleNo;
	
	@Column(name="major")
	private String major;
	
	@ManyToOne
	@JoinColumn(name = "batch_id")
	private AcademicBatch SubjectBatch;
	
	@ManyToOne
	@JoinColumn(name = "sem_id")
	private Semester SubjectSem;
}
