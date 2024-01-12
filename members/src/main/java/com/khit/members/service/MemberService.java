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
	
	//ȸ������ ���� ó��
	public void insert(MemberDTO memberDTO) { // void�� ��ȯ���� ����
		memberRepository.insert(memberDTO);
	}
	
	// �α��� ó��
	public MemberDTO login(MemberDTO memberDTO) {
		return memberRepository.login(memberDTO);
	}
	
	// ȸ�� ��� ����
	public List<MemberDTO> findAll() {
		return memberRepository.findAll();
	}
	// ȸ�� �� ����
	public MemberDTO findById(Long id) {
		return memberRepository.findById(id);
	}
	// ȸ�� ����
	public void delete(Long id) {
		memberRepository.delete(id);
	}
	// ȸ�� ���� ���� ������ - ���ǹ߱�
	public MemberDTO findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	// ȸ�� ���� ���� ó��
	public void update(MemberDTO memberDTO) {
		memberRepository.update(memberDTO);
	}
	// �̸��� �ߺ��˻�
	public String checkEmail(String email) {
		MemberDTO memberDTO = memberRepository.findByEmail(email);
		if(memberDTO == null) { // ã�� memberDTO(��ü)�� ������, ��밡���� �̸���
			return"OK";
		}else {
			return "NO";
		}
	}
	
}
