package com.magic.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.diary.domain.Diary;
import com.magic.diary.repo.DiaryDAO;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	DiaryDAO diaryDAO;
	
	@Override
	public void addDiary(Diary diary) throws Exception {
		diaryDAO.addDiary(diary);
	}

	@Override
	public boolean updateDiary(Diary diary) throws Exception {
		return diaryDAO.updateDiary(diary);
	}

	@Override
	public boolean deleteDiary(int diaryId) throws Exception {
		return diaryDAO.deleteDiary(diaryId);
	}

	@Override
	public Diary getDiary(int diaryId) throws Exception {
		return diaryDAO.getDiary(diaryId);
	}

	@Override
	public List<Diary> getAllDiary(String memId) throws Exception {
		return diaryDAO.getAllDiary(memId);
	}

	@Override
	public int countDiary(String memId) throws Exception {
		return diaryDAO.countDiary(memId);
	}

	@Override
	public List<Diary> countLabels(String memId) throws Exception {
		return diaryDAO.countLabels(memId);
	}

}
