package com.netchus.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.netchus.mapper.SensorMapper;
import com.netchus.util.PageMaker;

public class SensorServiceImpl implements SensorService {

	private SensorMapper mapper;
	
	@Autowired
	public SensorServiceImpl(SensorMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public ArrayList<HashMap<String, Object>> getListWithPaging(int pageNum, int amount) {
		return mapper.get(pageNum,amount);
	}
	
	public void setTotalCount(PageMaker pm) {
		pm.setTotalCount(mapper.getTotalCount());
	}

}
