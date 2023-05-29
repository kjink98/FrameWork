package com.konyang.admin.web;

import com.konyang.admin.service.MembersService;
import com.konyang.admin.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MembersApiController {
    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public Long save(@RequestBody MembersSaveRequestDto requestDto){
        return membersService.save(requestDto);
    }
}
