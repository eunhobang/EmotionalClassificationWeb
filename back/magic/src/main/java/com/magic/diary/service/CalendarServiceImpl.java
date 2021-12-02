package com.magic.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.diary.domain.Calendar;
import com.magic.diary.repo.CalendarDAO;


@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	CalendarDAO calendarDAO;

	@Override
	public boolean addEvent(Calendar calendar) throws Exception {

		return calendarDAO.addEvent(calendar);
	}

	@Override
	public boolean updateEvent(Calendar calendar) throws Exception {
		// TODO Auto-generated method stub
		return calendarDAO.updateEvent(calendar);
	}

	@Override
	public boolean deleteEvent(int calId) throws Exception {
		// TODO Auto-generated method stub
		return calendarDAO.deleteEvent(calId);
	}

	@Override
	public Calendar getEvent(int calId) throws Exception {
		// TODO Auto-generated method stub
		return calendarDAO.getEvent(calId);
	}

	@Override
	public List<Calendar> getAllEvent(String memId) throws Exception {
		// TODO Auto-generated method stub
		return calendarDAO.getAllEvent(memId);
	}
	
	
}
