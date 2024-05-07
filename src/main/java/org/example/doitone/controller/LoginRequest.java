package org.example.doitone.controller;

import lombok.Getter;

@Getter // Getter를 통해 직렬화와 역직렬화가 이루어지도록 함
public class LoginRequest { // 프론트로부터 받게 되는 JSON 형태
    private String loginId;
    private String password;
}
