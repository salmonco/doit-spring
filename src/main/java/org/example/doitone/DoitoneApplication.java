package org.example.doitone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ComponentScan이 있어서 스프링에 필요한 객체들을 컨테이너에 등록할 수 있다
@SpringBootApplication
public class DoitoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoitoneApplication.class, args);
    }

}
