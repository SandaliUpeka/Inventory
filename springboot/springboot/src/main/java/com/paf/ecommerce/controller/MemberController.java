package com.paf.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.ecommerce.dao.MemberDAO;
import com.paf.ecommerce.model.Member;




@RestController
@RequestMapping("/onlineShop")
public class MemberController {

	@Autowired
	MemberDAO memberDAO;
	
	//to save a member
	@PostMapping("/members")
	public Member createMember(@Valid @RequestBody Member p) {
		
		 return memberDAO.save(p);
	}
	
	
	
	
	//get all members
	@GetMapping("/members")
	public List<Member> getAllMembers(){
		
		return memberDAO.findAll();
	}
	
	//get member by id 
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable(value="id") Long memberID){
		
		Member p = memberDAO.findOne(memberID);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(p);
	}
	
	
	//update member details by memberID
	@PutMapping("/members/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable(value="id") Long memberID,@Valid @RequestBody Member memberDetails){
		
		Member p = memberDAO.findOne(memberID);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		
		//p.setId(memberDetails.getId());
		p.setUsername(memberDetails.getUsername());
		p.setPassword(memberDetails.getPassword());
		p.setEmail(memberDetails.getEmail());
		p.setAddress(memberDetails.getAddress());
		p.setMobile(memberDetails.getMobile());
		
		
		Member updateMember = memberDAO.save(p);
		return ResponseEntity.ok().body(updateMember);
	}
	
	
	//Delete a product
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Member> deleteMember(@PathVariable(value="id") Long memberID){
		
		Member p =memberDAO.findOne(memberID);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		
		memberDAO.delete(p);
		
		return ResponseEntity.ok().build();
	}
}