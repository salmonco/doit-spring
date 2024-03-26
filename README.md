# 1회차 (03.26.화)

## 스프링이란?
자바 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크 - 토비의 스프링

### What Spring can do?
<img src="https://jjunhub.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F634b8595-087d-452b-ad96-c6ec79db22a0%2F537747f9-c4c1-4c3f-96d6-19e612b5ac68%2FUntitled.png?table=block&id=308acb34-1ddd-410e-8e27-a4bd79e79d2a&spaceId=634b8595-087d-452b-ad96-c6ec79db22a0&width=1440&userId=&cache=v2">
여기선 Web apps를 주로 다룰 거다.

### 스프링의 주요 모듈
- **Spring MVC**
- **Spring Data**
- Spring Security
- etc …

## 스프링 부트를 사용해보자!
### 사전 준비물
- JDK 설치 : JDK 17
- IDE 설치 : IntelliJ 설치
- Postman 설치

### 스프링 프로젝트
`src → main → resources → static`에 `hello.html`만들고 `localhost:8080/hello.html` 주소 입력해서 GET 요청하면 스프링 부트 어플리케이션이 hello.html 페이지를 돌려준다.

## 스프링의 기본 원리

### 좋은 객체지향 설계
책 `코드로 이해하는 객체지향 설계` 읽어보면 도움된다.

### 스프링의 Bean
Spring 빈은 애플리케이션의 framework을 형성하고 Spring의 IoC 컨테이너에 의해 관리되는 객체이다.  
'new' 연산자를 사용하여 인스턴스화하는 일반 Java 객체와 달리 Spring 빈은 개발자가 제공한 구성 메타데이터를 사용하여 Spring 컨테이너에 의해 인스턴스화된다.  

이 때의 메타데이터는 XML로 작성될 수도 있고, **Java 기반 구성**을 따를 수도 있다.

1. **종속성 주입을 돕는다.**
2. 라이프사이클 관리가 가능하다.
3. 범위 지정 가능

### 스프링의 컨테이너
1. Bean 정의
2. Bean 생성 및 관리
3. 종속성 주입
4. 리소스 관리
5. 이벤트 처리

### 스프링의 의존성 주입
DI(Dependency Injection)는 Spring Framework의 기본 측면으로, 객체 생성 및 구성 관리에 대한 접근 방식을 구현한다.

각 개체는 종속성을 생성하지 않으며, 스프링 컨테이너라는 외부의 요소에 의해 종속성의 생성과 연결을 관리한다.

객체 간의 종속성을 해결하기 위해 IoC(Inversion of Control)를 구현하는 디자인 패턴이다.
1. 생성자 주입
2. Setter 주입
3. 필드 주입

```java
public class Main {
    public static void main(String[] args) {

        Child child = new Child();

        // Constructor
        ParentConstructor parent1 = new ParentConstructor(child);

        // Setter
        ParentSetter parent2 = new ParentSetter();
        parent2.setChild(child);

        // Field
        ParentField parent3 = new ParentField();
        parent3.child = child;
    }
}
```

**스프링 컨테이너를 통한 의존성 주입**
```java
@Configuration
public class AppConfig {

    @Bean // -> Spring Container에 추가됨
    public Child child() {
        return new Child();
    }

    @Bean
    public Parent parent(Child child) {
        return new Parent(child);
    }
}
```
