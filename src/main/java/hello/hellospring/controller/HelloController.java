package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 들어오면 아래 메서드 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        // controller에서 return 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리
        return "hello"; // hello.html로 연결
    }

}