package com.jvision.admin.web;

import com.jvision.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Junit에 내장된 실행자 외에 다른 실행자 실행
// 즉, 스프링부트 테스트와 Junit 사이 연결자 역할
@RunWith(SpringRunner.class)

// 스프링 테스트 어노테이션 중 스프링 MVC 집중
// @Controller, @ControllerAdvice 등 사용 가능
// @Service, @Component, @Repository 불가
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 스프링이 관리하는 Bean 주입
    // MockMvc 객체는 웹 API 테스트 시 사용
    // 이 클래스로 HTTP GET, POST API 테스트 가능
    @Autowired
    private MockMvc mvc;

    @Test

    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 GET 요청
        mvc.perform(get("/hello"))
                // HTTP Header의 상태 검증(200,404,500)
                .andExpect(status().isOk())
                // 본문 내용 검증
                .andExpect(content().string(hello));
    }

    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        String address = "konyang";

        mvc.perform(get("/hello/dto").param("name", name)
                        // param
                        // API 테스트할 때 사용될 요청 파라미터 설정
                        // 값은 String 타입만 허용
                        .param("amount", String.valueOf(amount))
                        .param("address", address))
                .andExpect(status().isOk())
                // jsonPath
                // JSON 응답값을 필드별로 검증하는 메소드
                // $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)))
                .andExpect(jsonPath("$.address", is((address))));

    }


}