package com.internship.sms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internship.sms.common.ActiveStatus;
import com.internship.sms.entity.Timetable;
import com.internship.sms.repository.TimetableRepository;
import com.internship.sms.service.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService {

	@Autowired
	TimetableRepository timetableRepository;

	@Override
	public List<Timetable> getAll() {
		// TODO Auto-generated method stub
		return timetableRepository.getAllTimeTableByActiveStatus(ActiveStatus.ACTIVE);
	}

	@Override
	public Timetable getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Timetable> optional = timetableRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Timetable create(Timetable timetable) {
		// TODO Auto-generated method stub
		return timetableRepository.save(timetable);
	}

	@Override
	public Timetable update(Timetable timetable) {
		// TODO Auto-generated method stub
		return timetableRepository.save(timetable);
	}

	@Override
	public boolean delete(Timetable timetable) {
		// TODO Auto-generated method stub
		try {
			timetableRepository.delete(timetable);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
