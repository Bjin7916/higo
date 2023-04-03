package com.higo.local;

import java.util.List;
import java.util.Map;

import com.higo.metro.MetroVO;

public class LocalService {

	
	private LocalDAO localDao;
	
	public void setLocalDao(LocalDAO localDao) {
		this.localDao = localDao;
	}
	
	public List<Map<String,Object>> localList(int seq){
		return localDao.localList(seq);
	}
	
	public List<Map<String,MetroVO>> metroList(){
		return localDao.metroList();
	}
	
	public List<Map<String,Object>> localMainSvc(Map<String,Object> map){
		
		return localDao.localMainSvc(map);
	}
	
	
}
