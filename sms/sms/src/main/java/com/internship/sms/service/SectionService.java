package com.internship.sms.service;

import java.util.List;

import com.internship.sms.dto.FilterDTO;
import com.internship.sms.entity.Section;

public interface SectionService {

	public List<Section> getAllSection();

	public Section getSectionById(Long id);

	public Section create(Section section);

	public Section update(Section section);

	public boolean delete(Section section);

	public List<Section> getSectionList(FilterDTO dto);

}
