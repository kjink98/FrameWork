package com.jvision.web.dto;

import com.jvision.admin.domain.posts.Posts;
import lombok.Getter;

@Getter
// 조회 결과를 Dto 객체로 변환하기 위한 코드
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;

    // DB로부터 넘어온 Posts 객체 entity를 PostsListResponseDto 객체로 변환

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();

    }
}
