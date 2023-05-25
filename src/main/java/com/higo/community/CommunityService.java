package com.higo.community;

import java.util.List;
import java.util.Map;

import com.higo.post.PostVO;

public class CommunityService {
	
	public CommunityDAO communityDao;

	public CommunityDAO getCommunityDao() {
		return communityDao;
	}

	public void setCommunityDao(CommunityDAO communityDao) {
		this.communityDao = communityDao;
	}
	
	public List<CommunityVO> selectList(Map<String, Object> map){
		List<CommunityVO> list = communityDao.selectList(map);
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		
		return list;
	}
	
	public int getTotal(Map<String, Object> map) {
		return communityDao.getTotal(map);
	}

}
