package org.example.doitone.repository;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member") // DB에 member 테이블이 생겨남
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 들어온 순서를 바탕으로 PK 부여
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "major", nullable = true)
    private String major;

    @Column(name = "student_number", nullable = true)
    private String studentNumber;

    @Column(name = "login_id", nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Builder
    public Member(Long id, String name, int age, String major, String studentNumber, String loginId, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.studentNumber = studentNumber;
        this.loginId = loginId;
        this.password = password;
    }
}
