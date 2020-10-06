package com.example.demo.repository;

import com.example.demo.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by mdtofazzal.hossain on 3/31/2019.
 */

@Service
public interface MemberRepository extends CrudRepository<Member, String> {
}
