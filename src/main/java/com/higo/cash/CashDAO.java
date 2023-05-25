package com.higo.cash;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.gosu.GosuVO;


public class CashDAO {
	
	private SqlSession sqlSession;
	
	public CashDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getCash(int cashKind_seq) {
		return sqlSession.selectOne("cash.getCash", cashKind_seq);
	}
	
	public int charge(CashVO vo) {
		
		return sqlSession.insert("cash.charge", vo);
	}
	
	public List<Map<String,Object>> chargeList(int gosu_seq) {
		return sqlSession.selectList("cash.chargeList", gosu_seq);
	}
	
	public int setCash(GosuVO vo) {
		return sqlSession.update("cash.setCash", vo);
	}
	
	

}
