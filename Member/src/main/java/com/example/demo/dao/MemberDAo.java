package com.example.demo.dao;

import com.example.demo.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

@Repository
public interface MemberDAo {

    Member findMemberByName(String userName);

    Member findMemberByEmail(String email);

    List<Member> getAllMember();

    Member createMember(Member form);

    Member findMemberById(Long id);

    boolean checkIsExistById(Long id);
}
