package com.ats.service;

import org.springframework.stereotype.Service;

import com.ats.command.TagDetailCommand;

@Service
public interface TagService {
	
	public String perchaseTag(TagDetailCommand tagDtle);

}
