package com.magic.diary.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.magic.diary.domain.Diary;

@Repository
public class DiaryDAOImpl implements DiaryDAO{

	private final String NS = "DiaryMapper.";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void addDiary(Diary diary) throws Exception {
		sqlSession.insert(NS+"addDiary", diary);
	}

	@Override
	public boolean updateDiary(Diary diary) throws Exception {
		int result = sqlSession.update(NS+"updateDiary", diary);
		if(result>0) return true;
		return false;
	}

	@Override
	public boolean deleteDiary(int diaryId) throws Exception {
		int result = sqlSession.delete(NS+"deleteDiary", diaryId);
		if(result>0) return true;
		return false;
	}

	@Override
	public Diary getDiary(int diaryId) throws Exception {
		
		return sqlSession.selectOne(NS+"getDiary", diaryId);
	}

	@Override
	public List<Diary> getAllDiary(String memId) throws Exception {

		return sqlSession.selectList(NS+"getAllDiary", memId);
	}

	@Override
	public int countDiary(String memId) throws Exception {
		return sqlSession.selectOne(NS+"countDiary", memId);
	}

	@Override
	public List<Diary> countLabels(String memId) throws Exception {
		return sqlSession.selectList(NS+"countLabels", memId);
	}

}
