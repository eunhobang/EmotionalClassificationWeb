package com.magic.diary.service;

import java.util.List;

import com.magic.diary.domain.Calendar;

public interface CalendarService {
	public boolean addEvent(Calendar calendar) throws Exception;
	public boolean updateEvent(Calendar calendar) throws Exception;
	public boolean deleteEvent(int calId) throws Exception;
	public Calendar getEvent(int calId) throws Exception;
	public List<Calendar> getAllEvent(String memId) throws Exception;
}
