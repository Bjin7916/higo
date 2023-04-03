package com.higo.cash;

import java.util.List;
import java.util.Map;

import com.higo.gosu.GosuVO;

public class CashService {
	
	private CashDAO cashDao;
	
	public void setCashDao(CashDAO cashDao) {
		this.cashDao = cashDao;
	}

	public int getCash(int cashKind_seq) {
		int su = 0;
		try {
			 su = cashDao.getCash(cashKind_seq);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return 0;
		}
		return su;
	}
	
	public int charge(CashVO vo) {
		return cashDao.charge(vo);
	}
	public List<Map<String,Object>> chargeList(int gosu_seq) {
		return cashDao.chargeList(gosu_seq);
	}
	
	public int setCash(GosuVO vo) {
		return cashDao.setCash(vo);
	}
}
