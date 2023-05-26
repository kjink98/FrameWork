package com.konyang.admin.web.dto;

import com.konyang.admin.domain.members.Members;
import lombok.Getter;

@Getter
public class MemebersResponseDto {
    private Long id;
    private String name;
    private String tel;
    private String addr;

    public MemebersResponseDto(Members entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.tel = entity.getTel();
        this.addr = entity.getAddr();

    }
}
