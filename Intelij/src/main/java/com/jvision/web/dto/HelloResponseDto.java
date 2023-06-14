package com.jvision.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 선언된 모든 필드에 get 메소드 생성
@Getter
// 선언된 final 필드가 포함된 생성자 주입
// final이 없는 필드는 생성자에 포함되지 않음
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
    private final String address;
}
