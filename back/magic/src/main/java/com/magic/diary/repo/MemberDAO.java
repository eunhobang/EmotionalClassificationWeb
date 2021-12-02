package com.magic.diary.repo;

import com.magic.diary.domain.Member;

public interface MemberDAO {
	
	public boolean addMember(Member member) throws Exception;
	public int idCheck(String memId) throws Exception;
	public Member login(Member member) throws Exception;
	public Member findID(Member member) throws Exception;
	public Member findPW(Member member) throws Exception;
	public boolean deleteMember(String memId) throws Exception;
	public boolean changePW(Member member) throws Exception;
}
