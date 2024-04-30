package org.example.doitone.domain;

import lombok.Getter;

@Getter
public class IntroduceResponse {
    String name;
    String introduction;

    public IntroduceResponse(String name, String introduction) {
        this.name = name;
        this.introduction = introduction;
    }
}
