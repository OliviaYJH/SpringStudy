package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 회원의 id 값

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 회원의 id 값 세팅
        store.put(member.getId(), member); // map에 저장장
       return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null 반환 가능성이 있으면 Optional.ofNullable()로 감싸기
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 돌면서
                .filter(member -> member.getName().equals(name)) // name이 parameter로 넘어온 값과 동일한지 확인
                .findAny(); // 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    } // store map의 values(Memeber)들 반환

    public void clearStore(){
        store.clear(); // 비움
    }
}
