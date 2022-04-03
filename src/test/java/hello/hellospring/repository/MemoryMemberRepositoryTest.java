package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 어떠한 메서든지 끝날때마다 동작함
    public void afterEach(){
        repository.clearStore(); // 저장소 비우기
    }

    // ctrl + shift + enter => 자동 완성..?
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        repository.findById(member.getId());

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(result, member); -> Junit
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
