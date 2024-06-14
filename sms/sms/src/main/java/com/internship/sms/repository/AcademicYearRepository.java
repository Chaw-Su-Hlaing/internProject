/**
 * 
 */
package com.internship.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.sms.entity.AcademicYear;

/**
 * Thu Soe San
 */
@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Long>{

}
