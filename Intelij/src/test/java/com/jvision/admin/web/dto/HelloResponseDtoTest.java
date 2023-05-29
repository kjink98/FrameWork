package com.jvision.admin.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
   @Test
   public void 롬북_기능_테스트(){
       String name = "test";
       int amount = 100;
       String address = "konyang";

       HelloResponseDto dto = new HelloResponseDto(name, amount, address);

       // assertThat 메소드 : 테스트 검증 라이브러리(assert)의 검증 메소드
       // isEqualTo 메소드 : 동등 비교 메소드
       assertThat(dto.getName()).isEqualTo(name);
       assertThat(dto.getAmount()).isEqualTo(amount);
       assertThat(dto.getAddress()).isEqualTo(address);


   }
}
