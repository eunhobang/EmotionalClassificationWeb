package com.magic.diary.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.magic.diary.domain.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{

	private final String NS = "MemberMapper.";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean addMember(Member member) throws Exception {
		int result = sqlSession.insert(NS+"addMember",member);
		if(result>0) return true;
		return false;
	}

	@Override
	public int idCheck(String memId) throws Exception {
		return sqlSession.selectOne(NS+"idCheck", memId);
	}

	@Override
	public Member login(Member member) throws Exception {
		return sqlSession.selectOne(NS+"login", member);
	}

	@Override
	public Member findID(Member member) throws Exception {
		return sqlSession.selectOne(NS+"findID", member);
	}

	@Override
	public Member findPW(Member member) throws Exception {
		return sqlSession.selectOne(NS+"findPW", member);
	}

	@Override
	public boolean deleteMember(String memId) throws Exception {
		int result = sqlSession.selectOne(NS+"deleteMember", memId);
		if(result>0) return true;
		return false;
	}

	@Override
	public boolean changePW(Member member) throws Exception {
		int result = sqlSession.selectOne(NS+"changePW", member);
		if(result>0) return true;
		return false;
	}

}
