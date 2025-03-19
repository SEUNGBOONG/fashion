package com.example.demo.profile.member.infrastructure.member;

import com.example.demo.profile.member.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    boolean existsByMemberNickName(String memberNickName);

    boolean existsByMemberEmail(String memberEmail);

    Optional<Member> findMemberByMemberEmail(String memberEmail);

    Optional<Member> findById(Long memberId);

}
