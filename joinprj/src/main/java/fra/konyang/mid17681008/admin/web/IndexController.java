package fra.konyang.mid17681008.admin.web;

import fra.konyang.mid17681008.admin.domain.members.Members;
import fra.konyang.mid17681008.admin.service.MembersService;
import fra.konyang.mid17681008.admin.web.dto.MembersResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Member;
import java.util.List;

@RequiredArgsConstructor
@Controller

public class IndexController {
    private final MembersService membersService;

    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/members/list")
    public String membersList(Model model) {
        model.addAttribute("members",membersService.findAllAsc());
        return "members-list";
    }
    @GetMapping("/members/save")
    public String membersSave() {
        return "members-save";
    }

    @GetMapping("/members/update/{num}")
    public String MembersUpdate(@PathVariable Long num, Model model){
        MembersResponseDto dto = membersService.findById(num);
        model.addAttribute("member", dto);
        return "members-update";
    }



}
