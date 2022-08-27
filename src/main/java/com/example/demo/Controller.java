package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {

    private final MemberRepository memberRepository;

    public Controller(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String home() {
        return "test 홈 페 이 지 입 니 다 ";
    }


    @PostMapping("/test")
    public ResponseEntity test(@RequestBody HashMap<String, String> map) {

        Member member = new Member();
        member.setName(map.get("name"));

        memberRepository.save(member);

        return new ResponseEntity<>("저장완료", HttpStatus.CREATED);
    }

}


