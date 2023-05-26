package com.konyang.admin.web;

import com.konyang.admin.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MembersService membersService;


    @GetMapping("/members/save")
    public String memberSave() {
        return "members-save";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("members",membersService.findAllAsc());
        return "index";
    }

}
