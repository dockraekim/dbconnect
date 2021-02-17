package com.netchus.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.netchus.util.PageMaker;

public interface SensorService {

	public ArrayList<HashMap<String,Object>> getListWithPaging(int pageNum, int amount);
	
	public void setTotalCount(PageMaker pm);
	
}
