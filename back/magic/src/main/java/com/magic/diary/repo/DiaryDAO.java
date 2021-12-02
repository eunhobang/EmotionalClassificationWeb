package com.magic.diary.repo;

import java.util.List;

import com.magic.diary.domain.Diary;

public interface DiaryDAO {

	 public void addDiary(Diary diary) throws Exception;
	 
	 public boolean updateDiary(Diary diary) throws Exception;
	 
	 public boolean deleteDiary(int diaryId) throws Exception;
	 
	 public Diary getDiary(int diaryId) throws Exception;
	 
	 public List<Diary> getAllDiary(String memId) throws Exception;
	 
	 public int countDiary(String memId) throws Exception;
	 
	 public List<Diary> countLabels(String memId) throws Exception;
	 
	 
}
