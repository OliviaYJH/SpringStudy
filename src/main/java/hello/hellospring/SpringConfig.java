package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 직접 등록 방법
@Configuration
public class SpringConfig {

    @Bean // 스프링 빈 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    /*
    memberService와 memberRepository를 모두 Bean에 등록
    -> 등록되어 있는 memberRepository를 MemberService에 넣어줌
     */
}
