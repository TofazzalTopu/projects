package info.com.member.repository;

import info.com.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
