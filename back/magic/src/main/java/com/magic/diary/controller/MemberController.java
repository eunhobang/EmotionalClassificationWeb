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

import com.magic.diary.domain.Member;
import com.magic.diary.service.MemberService;

@RestController
@RequestMapping("magic")
@CrossOrigin(origins= {"*"}, maxAge=6000)
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/addMember")
	public ResponseEntity addMember(@RequestBody Member member) throws Exception{
		memberService.addMember(member);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/idCheck/{memId}")
	public ResponseEntity idCheck(@PathVariable String memId) throws Exception{
		System.out.println("aaaa");
		return new ResponseEntity(memberService.idCheck(memId), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody Member member) throws Exception{
		Member loginMember = memberService.login(member);
		if(loginMember!=null) {
			return new ResponseEntity(loginMember, HttpStatus.OK);
		}else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("findPW/{memId}/{memName}/{memAnniversary}/{memDate}")
	public ResponseEntity findPW(@PathVariable String memId, @PathVariable String memName, @PathVariable String memAnniversary, @PathVariable String memDate) throws Exception{
		Member member = new Member(memId, memName, memAnniversary, memDate);
		Member findMember = memberService.findPW(member);
		if(findMember==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(findMember, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteMember/{memId}")
	public ResponseEntity deleteMember(@PathVariable String memId) throws Exception{
		boolean result = memberService.deleteMember(memId);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("changePW/{memId}/{memPw}")
	public ResponseEntity changePW(@PathVariable String memId, @PathVariable String memPw) throws Exception{
		Member member = new Member();
		member.setMemId(memId);
		member.setMemPw(memPw);
		boolean result = memberService.changePW(member);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
	
	
	
}
