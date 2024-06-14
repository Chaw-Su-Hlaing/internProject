/**
 * 
 */
package com.internship.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.sms.entity.Department;

/**
 * Thu Soe San
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
