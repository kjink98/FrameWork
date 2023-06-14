package com.jvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링부트의 자동설정, 스프링 객체(Bean) 읽기와 생성 모두 자동 설정
// 항상 프로젝트 최상단에 위치해야 함
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // 내장 WAS (웹 에플리케이션 서버, 톰캣) 실행
        // 내장 WAS 이점 - 언제 어디서나 같은 환경에서 스프링 부트 배포 가능
        SpringApplication.run(Application.class, args);
    }
}
//http://localhost:8080/hello/
//http://localhost:8080/hello/dto?name=jingwang&amount=10000