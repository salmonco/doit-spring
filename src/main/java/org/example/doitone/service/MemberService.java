package org.example.doitone.service;

import org.example.doitone.controller.LoginRequest;
import org.example.doitone.controller.SignUpRequest;
import org.example.doitone.repository.Member;
import org.example.doitone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }


    public void signUp(SignUpRequest signUpRequest) {

        memberRepository.findByLoginId(signUpRequest.getLoginId())
                .ifPresent(member -> {
                    throw new IllegalArgumentException("이미 존재하는 로그인 아이디입니다.");
                });

        Member member = Member.builder()
                .name(signUpRequest.getName())
                .age(signUpRequest.getAge())
                .studentNumber(signUpRequest.getStudentNumber())
                .major(signUpRequest.getMajor())
                .loginId(signUpRequest.getLoginId())
                .password(signUpRequest.getPassword())
                .build();

        memberRepository.save(member);
    }

    public Member login(LoginRequest loginRequest) {
        return memberRepository.findByLoginIdAndPassword(loginRequest.getLoginId(), loginRequest.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("로그인 정보가 올바르지 않습니다."));

    }


    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
    }


}
