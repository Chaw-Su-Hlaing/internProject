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
@Table(name="family")

public class FamilyMember extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2543362043005795781L;
	@Column(name="parent_name")
	private String name;
	
	@Column(name="relation")
	private String relationStatus;
	
	@Column(name="phone_no")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="guardian_status")
	private boolean guardian;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="nrcNo")
	private String nrcNo;
	
	
	@Column(name="Nation")
	private String nation;
	
	
	@Column(name="religion")
	private String religion;

	
}
