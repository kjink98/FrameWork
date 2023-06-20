package fra.konyang.mid17681008.admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class MembersUpdateRequestDto {

        private String id;
        private String name;
        private String pass;
        private String email;



    @Builder
        public MembersUpdateRequestDto(String id, String name, String pass, String email){
            this.id = id;
            this.name = name;
            this.pass = pass;
            this.email = email;
        }
}
