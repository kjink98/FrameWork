package fra.konyang.mid17681008.admin.web.dto;

import fra.konyang.mid17681008.admin.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String id;
    private String name;
    private String pass;
    private String email;

    @Builder
    public MembersSaveRequestDto(String id, String name, String pass, String email) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public Members toEntity() {
        return Members.builder()
                .id(id)
                .name(name)
                .pass(pass)
                .email(email)
                .build();
    }
}
