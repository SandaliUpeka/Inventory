package com.paf.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.ecommerce.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
