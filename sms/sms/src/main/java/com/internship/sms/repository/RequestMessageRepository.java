/**
 * 
 */
package com.internship.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.internship.sms.common.ActiveStatus;
import com.internship.sms.entity.RequestMessage;

/**
 * 
 */
@Repository
public interface RequestMessageRepository extends JpaRepository<RequestMessage, Long>{
	@Query("select u from RequestMessage u where u.activeStatus = :activeStatus")
	List<RequestMessage> getAllByActiveStatus(@Param("activeStatus") ActiveStatus activeStatus);
}
