package com.internship.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.sms.entity.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

}
