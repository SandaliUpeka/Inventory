package com.paf.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.ecommerce.model.Member;
import com.paf.ecommerce.repository.MemberRepository;

@Service
public class MemberDAO {
	@Autowired
	MemberRepository memberRepository;
	
	// to save a member
	public Member save(Member m) {
		
		return memberRepository.save(m);
	}
	
	//to search all members
	public List<Member> findAll(){
		
		return memberRepository.findAll();
	}
	
	//get a member by id
	public Member findOne(Long memberID) {
		
		return memberRepository.findOne(memberID);
	}
	
	//delete member
	public void delete(Member p) {
		
		memberRepository.delete(p);
	}
	
}
