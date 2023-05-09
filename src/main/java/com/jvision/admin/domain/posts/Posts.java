package com.jvision.admin.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 롬북의 어노테이션(코드 단순화, 필수는 아님)
@Getter
// 묵시적 생성자 생성
@NoArgsConstructor

// JPA의 어노테이션(SQL 생성)
// 테이블과 링크될 클래스임을 나타냄
// 기본값으로 클래스의 이름을 언더스코어 네이밍(_)으로 테이블 이름 매칭
// 예) SalesManager.java -> sales_manager table
@Entity
public class Posts {
    // 해당 테이블의 PK 필드를 나타냄
    @Id
    // PK의 생성 규칙을 나타냄
    // GenerationType.IDENTITY란 auto_increment를 의미함(스프링 부트 3.0 기준)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 테이블 컬럼을 의미함
    // 생략해도 멤버변수는 컬럼에 해당하며, 속성 변경이 필요한 경우 명시적으로 사용함
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 롬북의 어노테이션(코드 단순화, 필수는 아님)
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
