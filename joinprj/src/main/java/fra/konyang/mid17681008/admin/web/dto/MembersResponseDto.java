package fra.konyang.mid17681008.admin.web.dto;

import fra.konyang.mid17681008.admin.domain.members.Members;
import lombok.Getter;

@Getter
public class MembersResponseDto {
    private Long num;
    private String id;
    private String name;
    private String pass;
    private String email;

    public MembersResponseDto(Members entity){
        this.num = entity.getNum();
        this.id = entity.getId();
        this.name = entity.getName();
        this.pass = entity.getPass();
        this.email = entity.getEmail();
    }
}
