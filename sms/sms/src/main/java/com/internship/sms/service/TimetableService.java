package com.internship.sms.service;

import java.util.List;

import com.internship.sms.entity.Timetable;

public interface TimetableService {

	public List<Timetable> getAll();

	public Timetable getById(Long id);

	public Timetable create(Timetable timetable);

	public Timetable update(Timetable timetable);

	public boolean delete(Timetable timetable);
}
