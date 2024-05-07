package org.example.doitone.controller;

import org.example.doitone.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 목록 조회
     *
     * @param memberJoinRequest 회원 가입 요청
     * @return List<Member>
     */
    @GetMapping("/member")
    public ResponseEntity getMemberList() {
        return ResponseEntity.ok(memberService.findAllMember());
    }

    /**
     * 회원 추가
     *
     * @return "{}"
     */
    @PostMapping("/signup")
    public ResponseEntity addMember(@RequestBody SignUpRequest signUpRequest) {
        memberService.signUp(signUpRequest);
        return ResponseEntity.ok("{}");
    }

    /**
     * 로그인
     *
     * @param loginRequest 아이디, 비밀번호
     * @return 로그인한 회원 정보
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(memberService.login(loginRequest));
    }

    /**
     * 회원 조회
     *
     * @param id 회원 id
     * @return 회원 정보
     */
    @GetMapping("/member/{id}")
    public ResponseEntity getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findMember(id));
    }
}
