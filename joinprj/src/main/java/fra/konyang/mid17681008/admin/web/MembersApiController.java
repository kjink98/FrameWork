package fra.konyang.mid17681008.admin.web;

import fra.konyang.mid17681008.admin.service.MembersService;
import fra.konyang.mid17681008.admin.web.dto.MembersResponseDto;
import fra.konyang.mid17681008.admin.web.dto.MembersSaveRequestDto;
import fra.konyang.mid17681008.admin.web.dto.MembersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MembersApiController {
    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public Long save(@RequestBody MembersSaveRequestDto requestDto) {
        return membersService.save(requestDto);
    }

    @PutMapping("/api/v1/members/{num}")
    public Long update(@PathVariable Long num, @RequestBody MembersUpdateRequestDto requestDto){
        return membersService.update(num, requestDto);
        // 클라이언트의 수정 요청 처리 메소드
    }

    @GetMapping("/api/v1/members/{num}")
    public MembersResponseDto findById(@PathVariable Long num){
        return membersService.findById(num);
        // 클라이언트의 삭제 요청 처리 메소드
    }

    @DeleteMapping("/api/v1/members/{num}")
    public Long delete(@PathVariable Long num){
        membersService.delete(num);
        return num;
        // DB내 members 삭제 후 id 리턴
    }
}
