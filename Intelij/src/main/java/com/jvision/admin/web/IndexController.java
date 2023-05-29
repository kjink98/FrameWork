package com.jvision.admin.web;

import com.jvision.admin.service.PostsService;
import com.jvision.admin.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 진입점
@Controller
public class IndexController {

    private PostsService postsService;

    public IndexController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // index에 확장자가 자동 지정
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; // /posts/save를 호출하면 posts-save 리턴. 즉, posts-save.mustache 파일 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-update";
    }
}