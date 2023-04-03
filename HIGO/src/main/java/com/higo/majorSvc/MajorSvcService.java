package com.higo.majorSvc;

import java.util.List;
import java.util.Map;

public class MajorSvcService {
	
	private MajorSvcDAO majorSvcDao;
	
	public void setMajorSvcDao(MajorSvcDAO majorSvcDao) {
		this.majorSvcDao = majorSvcDao;
	}
	
	public List<Map<String, Object>> major(){
		List<Map<String, Object>> list = null;
		try {
			list = majorSvcDao.major(); 
		}catch(Exception e) {
			e.printStackTrace();
		
		}
		
		return list;
	}
	
	
}
