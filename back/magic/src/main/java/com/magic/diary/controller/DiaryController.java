package com.magic.diary.controller;

import java.util.List;

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

import com.magic.diary.domain.Diary;
import com.magic.diary.service.DiaryService;

@RestController
@RequestMapping("magic")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class DiaryController {

	@Autowired
	private DiaryService service;
	
	@PostMapping("addDiary")
	public ResponseEntity addDiary(@RequestBody Diary diary) throws Exception{
//		diary.setDiaryContents(diary.getDiaryContents().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		service.addDiary(diary);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("updateDiary")
	public ResponseEntity updateDiary(@RequestBody Diary diary) throws Exception{
		diary.setDiaryContents(diary.getDiaryContents().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		boolean result = service.updateDiary(diary);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("deleteDiary/{diaryId}")
	public ResponseEntity deleteDiary(@PathVariable int diaryId) throws Exception{
		boolean result = service.deleteDiary(diaryId);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("getDiary/{diaryId}")
	public ResponseEntity getDiary(@PathVariable int diaryId) throws Exception{
		System.out.println("aaa");
		Diary diary = service.getDiary(diaryId);
		diary.setDiaryContents(diary.getDiaryContents().replaceAll("<br>", "\n"));
		if(diary == null) {
			System.out.println("aaaaaaa");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		System.out.println("vvvvvv");
		return new ResponseEntity(diary, HttpStatus.OK);
	}
	
	@GetMapping("getAllDiary/{memId}") // page?!
	public ResponseEntity getAllDiary(@PathVariable String memId) throws Exception{
		List<Diary> diarys = service.getAllDiary(memId);
		if(diarys.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(diarys, HttpStatus.OK);
	}
	
	@GetMapping("countDiary/{memId}")
	public ResponseEntity countDiary(@PathVariable String memId) throws Exception{
		return new ResponseEntity(service.countDiary(memId) ,HttpStatus.OK);
	}
	
	@GetMapping("countLabels/{memId}")
	public ResponseEntity countLabels(@PathVariable String memId) throws Exception{
		return new ResponseEntity(service.countLabels(memId), HttpStatus.OK);
	}
	
	// mapper 참고해서 작성
}
