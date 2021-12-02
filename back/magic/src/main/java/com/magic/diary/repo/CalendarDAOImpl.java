package com.magic.diary.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.magic.diary.domain.Calendar;

@Repository
public class CalendarDAOImpl implements CalendarDAO{
	
	private String ns = "CalendarMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean addEvent(Calendar calendar) throws Exception {
		int result = sqlSession.insert(ns + "addEvent", calendar);
		if(result>0) return true;
		return false;
	}

	@Override
	public boolean updateEvent(Calendar calendar) throws Exception {
		int result = sqlSession.update(ns + "updateEvent", calendar);
		if(result>0) return true;
		return false;
	}

	@Override
	public boolean deleteEvent(int calId) throws Exception {
		int result = sqlSession.delete(ns + "deleteEvent", calId);
		if(result>0) return true;
		return false;
	}

	@Override
	public Calendar getEvent(int calId) throws Exception {
		return sqlSession.selectOne(ns + "getEvent", calId);
	}

	@Override
	public List<Calendar> getAllEvent(String memId) throws Exception {
		return sqlSession.selectList(ns + "getAllEvent", memId);
	}
	
}
