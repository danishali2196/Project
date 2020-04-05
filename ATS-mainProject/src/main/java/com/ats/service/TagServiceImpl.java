package com.ats.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.command.TagDetailCommand;
import com.ats.entity.TagDetailsEntity;
import com.ats.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	TagRepository tagRepo;

	@Override
	public String perchaseTag(TagDetailCommand tagDtle) {
		TagDetailsEntity entity = new TagDetailsEntity();
		BeanUtils.copyProperties(tagDtle, entity);
		TagDetailsEntity checkVhclExistence = tagRepo.vehicleSearchByRegNo(entity.getVchlRegNo());
		if (null == checkVhclExistence) {
			Integer vhclId = (int) (Math.random()*100000);
			entity.setTagId(vhclId);
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			entity.setTagStartDate(today);
			cal.add(Calendar.YEAR, 3);
			Date threeYear = cal.getTime();
			entity.setTagExpDate(threeYear);
			entity.setTagBal(1000);
			
			tagRepo.save(entity);
		}
		return "record Save";
	}


}
