package com.jvision.web;

import com.jvision.admin.config.auth.dto.SessionUser;
import com.jvision.service.posts.PostsService;
import com.jvision.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model){
        // postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달

        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser users = (SessionUser) httpSession.getAttribute("users");

        if(users != null)
            model.addAttribute("userName", users.getName());

        return "index"; // index에 확장자가 자동 지정
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
        // /posts/save를 호출하면 posts-save 리턴. 즉, posts-save.mustache 파일 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
