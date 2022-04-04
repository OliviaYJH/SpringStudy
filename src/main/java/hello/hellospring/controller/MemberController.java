package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // controller -> 객체 생성 -> 스프링 컨테이너에서 스프링 빈이 관리됨
public class MemberController {
    private final MemberService memberService;

    // 스프링 컨테이너에 등록
    @Autowired // 스프링이 컨테이너에 있는 memberService를 가져다 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
