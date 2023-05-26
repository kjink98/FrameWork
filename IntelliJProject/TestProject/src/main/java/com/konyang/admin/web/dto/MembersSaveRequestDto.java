package com.konyang.admin.web.dto;

import com.konyang.admin.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String name;
    private String tel;
    private String addr;

    @Builder
    public MembersSaveRequestDto(String name, String tel, String addr){
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .tel(tel)
                .addr(addr)
                .build();
    }
}
