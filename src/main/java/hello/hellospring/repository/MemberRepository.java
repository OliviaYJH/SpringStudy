package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { // repository => 저장소
    Member save(Member member); // 저장소에 저장
    Optional<Member> findById(Long id); // findById로 찾기
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 모든 정보 반환
}
