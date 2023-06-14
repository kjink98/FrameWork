package com.jvision.admin.config.auth.dto;

import com.jvision.admin.domain.users.Users;
import lombok.Getter;

import java.io.Serializable;
// 다른 사람이 로그인을 할 때 사용하는 클래스
// Users 클래스와 차이점 - 직렬화
// 자바 내부 Object를 외부에서 사용 가능하도록 byte 형태로 변환하는 기술
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(Users users){
        this.name = users.getName();
        this.email = users.getEmail();
        this.picture = users.getPicture();
    }
}