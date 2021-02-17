package com.netchus.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface SensorMapper {
	
	public ArrayList<HashMap<String,Object>> get(@Param("pageNum")int pageNum, @Param("amount")int amount);
	
	public int getTotalCount();
	
}
