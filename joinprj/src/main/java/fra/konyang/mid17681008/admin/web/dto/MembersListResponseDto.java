package fra.konyang.mid17681008.admin.web.dto;

import fra.konyang.mid17681008.admin.domain.members.Members;
import lombok.Getter;

@Getter
public class MembersListResponseDto {
    private Long num;
    private String id;
    private String name;
    private String pass;
    private String email;

    // DB로부터 넘어온 Posts 객체 entity를 PostsListResponseDto 객체로 변환
    public MembersListResponseDto(Members entity) {
        this.num = entity.getNum();
        this.id = entity.getId();
        this.name = entity.getName();
        this.pass = entity.getPass();
        this.email = entity.getEmail();
    }
}
