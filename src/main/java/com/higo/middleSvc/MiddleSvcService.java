package com.higo.middleSvc;

import java.util.List;
import java.util.Map;

public class MiddleSvcService {
	
	public MiddleSvcDAO middleSvcDao;
	
	public void setMiddleSvcDao(MiddleSvcDAO middleSvcDao) {
		this.middleSvcDao = middleSvcDao;
	}
	
	public List<MiddleSvcVO> middleSvcSelect(int majorSvc_seq) {
		
		List<MiddleSvcVO> mlist = middleSvcDao.middleSvcSelect(majorSvc_seq);
		
		if(mlist.isEmpty()) {
			System.out.println(mlist);
			mlist = null;
		}
		return mlist;
	}
	public List<Map<String, Object>> middle(int majorSvc_seq){
		return middleSvcDao.middle(majorSvc_seq);
	}
	
	
}
