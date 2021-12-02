package com.magic.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.diary.domain.Calendar;
import com.magic.diary.service.CalendarService;

@RestController
@RequestMapping("calendar")
@CrossOrigin(origins= {"*"}, maxAge=6000)
public class CalendarController {

	@Autowired
	private CalendarService calendarService;
	
	@PostMapping("/addEvent")
	public ResponseEntity addEvent(@RequestBody Calendar calendar) throws Exception{
		boolean result = calendarService.addEvent(calendar);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/updateEvent")
	public ResponseEntity updateEvent(@RequestBody Calendar calendar) throws Exception{
		boolean result = calendarService.updateEvent(calendar);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEvent/{calId}")
	public ResponseEntity deleteEvent(@PathVariable int calId) throws Exception{
		boolean result = calendarService.deleteEvent(calId);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/getEvent/{calId}")
	public ResponseEntity getEvent(@PathVariable int calId) throws Exception{
		return new ResponseEntity(calendarService.getEvent(calId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllEvent/{memId}")
	public ResponseEntity getAllEvent(@PathVariable String memId) throws Exception{
		return new ResponseEntity(calendarService.getAllEvent(memId), HttpStatus.OK);
	}

}
