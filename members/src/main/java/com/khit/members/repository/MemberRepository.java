package com.khit.members.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.khit.members.dto.MemberDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class MemberRepository {

	private SqlSessionTemplate sql; //root-context.xml에서 정의한 것
	
	// insert(삽입), update(변경), delete(삭제)
	// selectOne(상세보기), selectList(목록보기)
	
	// 회원가입 정보 처리
	public void insert(MemberDTO memberDTO) {
		sql.insert("Member.insert", memberDTO); // "Member" 별칭이 memberMapper 임
	}
	
	// 로그인 처리
	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO);
	}
	// 회원 목록 조회
	public List<MemberDTO> findAll(){
		return sql.selectList("Member.findAll");
	}
	// 회원 상세보기
	public MemberDTO findById(Long id) {
		return sql.selectOne("Member.findById", id);
	}
	// 회원 삭제
	public void delete(Long id) { // 파라미터로 넘겨주기
		sql.delete("Member.delete", id);
	}
	// 회원 정보 수정 페이지 - 세션발급
	public MemberDTO findByEmail(String email) {
		return sql.selectOne("Member.findByEmail", email);
	}
	// 회원정보 수정 처리
	public void update(MemberDTO memberDTO) {
		sql.update("Member.update", memberDTO);
	}
}
