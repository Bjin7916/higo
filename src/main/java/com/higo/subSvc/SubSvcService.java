package com.higo.subSvc;

import java.util.List;
import java.util.Map;

public class SubSvcService {
	
	public SubSvcDAO subSvcDao;
	
	public void setSubSvcDao(SubSvcDAO subSvcDao) {
		this.subSvcDao = subSvcDao;
	}
	
	public List<SubSvcVO> subSvcSelect(int majorSvc_seq){
			
			List<SubSvcVO> slist = subSvcDao.subSvcSelect(majorSvc_seq);
			
			if(slist.isEmpty()) {
				System.out.println(slist);
				slist = null;
			}
			return slist;
	}
	
	public SubSvcVO subSvcSelectVO(int subSvc_seq) {
		return subSvcDao.subSvcSelectVO(subSvc_seq);
	}
	
	public String selectSubName(int subSvc_seq) {
		return subSvcDao.selectSubName(subSvc_seq);
	}

	public List<Map<String, Object>> sub(int middleSvc_seq){
		return subSvcDao.sub(middleSvc_seq);
	}
	
	public List<Map<String, Object>> subSvcAll(){
		return subSvcDao.subSvcAll();
	}
	
}
