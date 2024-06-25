/**
 * 
 */
package com.internship.sms.entity;

import java.io.Serializable;

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
@Table(name="Family")

public class FamilyMember extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2543362043005795781L;
	@Column(name="parent_name")
	private String par_name;
	
	@Column(name="Relation")
	private String relationStatus;
	
	@Column(name="parent_phone_no")
	private String par_phone;
	
	@Column(name="Address")
	private String par_address;
	
	@Column(name="guardian_status")
	private boolean guardian;
	
	@Column(name="parent_occupation")
	private String par_occupation;
	
	@Column(name="parent_nrcNo")
	private String par_nrcNo;
	
	
	@Column(name="Parent_National")
	private String par_national;
	
	
	@Column(name="religion")
	private String par_religion;

	
}
