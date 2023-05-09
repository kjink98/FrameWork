package com.jvision.admin.web;

import com.jvision.admin.service.PostsService;
import com.jvision.admin.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
// Controller은 토스해주는 역할
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // PostMapping은 입력값이 안보임
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
