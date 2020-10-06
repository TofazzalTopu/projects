package com.example.demo.service;

import com.example.demo.action.MemberAction;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mdtofazzal.hossain on 3/31/2019.
 */

@Service("memberService")
@Transactional
public class MemberService implements MemberAction{

    @Autowired
    MemberRepository memberRepository;


    @Override
    public List<Member> getAllMembers() {
        return null;
    }

    @Override
    public Member getMemberById(long id) {
        Member member = new Member();
        member.setMemberId(111L);
        member.setMemberName("RANA");
        member.setAddress("Dhaka");
        member.setPassword("123");
        member.setId(id);
        return member;
    }

    @Override
    public Member getMemberByName(String name) {
        return null;
    }

    @Override
    public void saveOrUpdate(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }
}
