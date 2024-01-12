package com.khit.members.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khit.members.dto.MemberDTO;
import com.khit.members.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	//회원가입 정보 처리
	public void insert(MemberDTO memberDTO) { // void는 반환값이 없음
		memberRepository.insert(memberDTO);
	}
	
	// 로그인 처리
	public MemberDTO login(MemberDTO memberDTO) {
		return memberRepository.login(memberDTO);
	}
	
	// 회원 목록 보기
	public List<MemberDTO> findAll() {
		return memberRepository.findAll();
	}
	// 회원 상세 보기
	public MemberDTO findById(Long id) {
		return memberRepository.findById(id);
	}
	// 회원 삭제
	public void delete(Long id) {
		memberRepository.delete(id);
	}
	// 회원 정보 수정 페이지 - 세션발급
	public MemberDTO findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	// 회원 정보 수정 처리
	public void update(MemberDTO memberDTO) {
		memberRepository.update(memberDTO);
	}
	// 이메일 중복검사
	public String checkEmail(String email) {
		MemberDTO memberDTO = memberRepository.findByEmail(email);
		if(memberDTO == null) { // 찾는 memberDTO(객체)가 없으면, 사용가능한 이메일
			return"OK";
		}else {
			return "NO";
		}
	}
	
}
