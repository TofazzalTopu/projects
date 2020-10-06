package com.example.demo.action;

import com.example.demo.model.Member;

import java.util.List;

/**
 * Created by mdtofazzal.hossain on 3/31/2019.
 */
public interface MemberAction {

    List<Member> getAllMembers();

    Member getMemberById(long id);

    Member getMemberByName(String name);

    void saveOrUpdate(Member member);

    void deleteMember(Member member);
}
