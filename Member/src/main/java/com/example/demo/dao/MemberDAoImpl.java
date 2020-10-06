package com.example.demo.dao;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

@Service
public class MemberDAoImpl implements MemberDAo {

    private static final Map<Long, Member> MEMBER_MAP = new HashMap<>();

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Member findMemberByName(String userName) {
        Iterable<Member> memberList = memberRepository.findAll();
        for (Member u : memberList) {
            if (u.getMemberName().equals(userName)) {
                return u;
            }
        }
        return null;
    }


    @Override
    public boolean checkIsExistById(Long id) {
        Iterable<Member> memberList = memberRepository.findAll();
        for (Member u : memberList) {
            if (u.getMemberName().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Member findMemberById(Long id) {
        Iterable<Member> memberList = memberRepository.findAll();
        for (Member u : memberList) {
            if (u.getMemberName().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Member findMemberByEmail(String email) {
        Collection<Member> members = MEMBER_MAP.values();
        for (Member u : members) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Member> getAllMember() {
        List<Member> list = new ArrayList<>();
        Iterable<Member> memberList = memberRepository.findAll();

        for (Member u : memberList) {
            list.add(u);
        }
        return list;
    }

    @Override
    public Member createMember(Member form) {
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());

        Member member1 = new Member();
        member1.setMemberId(form.getMemberId());
        member1.setMemberName(form.getMemberName());
        member1.setPassword(encrytedPassword);
        member1.setAddress(form.getAddress());
        member1.setEmail(form.getEmail());

        memberRepository.save(member1);
        return member1;
    }
}
