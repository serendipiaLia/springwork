package com.khit.members.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.khit.members.dto.MemberDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class MemberRepository {

	private SqlSessionTemplate sql; //root-context.xml���� ������ ��
	
	// insert(����), update(����), delete(����)
	// selectOne(�󼼺���), selectList(��Ϻ���)
	
	// ȸ������ ���� ó��
	public void insert(MemberDTO memberDTO) {
		sql.insert("Member.insert", memberDTO); // "Member" ��Ī�� memberMapper ��
	}
	
	// �α��� ó��
	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO);
	}
	// ȸ�� ��� ��ȸ
	public List<MemberDTO> findAll(){
		return sql.selectList("Member.findAll");
	}
	// ȸ�� �󼼺���
	public MemberDTO findById(Long id) {
		return sql.selectOne("Member.findById", id);
	}
	// ȸ�� ����
	public void delete(Long id) { // �Ķ���ͷ� �Ѱ��ֱ�
		sql.delete("Member.delete", id);
	}
	// ȸ�� ���� ���� ������ - ���ǹ߱�
	public MemberDTO findByEmail(String email) {
		return sql.selectOne("Member.findByEmail", email);
	}
	// ȸ������ ���� ó��
	public void update(MemberDTO memberDTO) {
		sql.update("Member.update", memberDTO);
	}
}
