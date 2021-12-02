package com.magic.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.diary.domain.Member;
import com.magic.diary.repo.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public boolean addMember(Member member) throws Exception {
		return memberDAO.addMember(member);
	}

	@Override
	public int idCheck(String memId) throws Exception {
		return memberDAO.idCheck(memId);
	}

	@Override
	public Member login(Member member) throws Exception {
		return memberDAO.login(member);
	}

	@Override
	public Member findID(Member member) throws Exception {
		return memberDAO.findID(member);
	}

	@Override
	public Member findPW(Member member) throws Exception {
		return memberDAO.findPW(member);
	}

	@Override
	public boolean deleteMember(String memId) throws Exception {
		return memberDAO.deleteMember(memId);
	}

	@Override
	public boolean changePW(Member member) throws Exception {
		return memberDAO.changePW(member);
	}

}
