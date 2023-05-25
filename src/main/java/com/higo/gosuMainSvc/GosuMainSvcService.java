package com.higo.gosuMainSvc;

public class GosuMainSvcService {
	
	private GosuMainSvcDAO gosuMainSvcDao;
	
	public void setGosuMainSvcDao(GosuMainSvcDAO gosuMainSvcDao) {
		this.gosuMainSvcDao = gosuMainSvcDao;
	}
	
	public GosuMainSvcVO selectGosuMS(int gosuMS_seq) {
		return gosuMainSvcDao.selectGosuMS(gosuMS_seq);
	}
	
	public GosuMainSvcVO selectSMM(int gosu_seq) {
		return gosuMainSvcDao.selectSMM(gosu_seq);
	}
}
