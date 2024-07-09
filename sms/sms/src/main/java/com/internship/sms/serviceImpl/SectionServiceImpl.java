package com.internship.sms.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.sms.common.ActiveStatus;
import com.internship.sms.entity.AcademicBatch;
import com.internship.sms.entity.Section;
import com.internship.sms.repository.SectionRepository;
import com.internship.sms.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	SectionRepository sectionRepository;

	@Override
	public List<Section> getAllSection() {
		// TODO Auto-generated method stub
		return sectionRepository.getAllByActiveStatus(ActiveStatus.ACTIVE);
	}

	@Override
	public Section getSectionById(Long id) {
		// TODO Auto-generated method stub
		Optional<Section> optional = sectionRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Section create(Section section) {
		// TODO Auto-generated method stub
		return sectionRepository.save(section);
	}

	@Override
	public Section update(Section section) {
		// TODO Auto-generated method stub
		return sectionRepository.save(section);
	}

	@Override
	public boolean delete(Section section) {
		// TODO Auto-generated method stub
		try {
			sectionRepository.delete(section);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Section> getSectionList( AcademicBatch batch, String major) {
		// TODO Auto-generated method stub
		return sectionRepository.findAll();
	}



}
