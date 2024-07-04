package com.internship.sms.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "section")
public class Section extends AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	@Column(name = "major")
	private String classMajor;

	@Column(name = "No_of_student")
	private String noOfStudent;

	@ManyToOne
	@JoinColumn(name = "academicBatch_id")
	private AcademicBatch academicBatch;
}
