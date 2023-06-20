package fra.konyang.mid17681008.admin.service;

import fra.konyang.mid17681008.admin.domain.members.Members;
import fra.konyang.mid17681008.admin.domain.members.MembersRepository;
import fra.konyang.mid17681008.admin.web.dto.MembersListResponseDto;
import fra.konyang.mid17681008.admin.web.dto.MembersResponseDto;
import fra.konyang.mid17681008.admin.web.dto.MembersSaveRequestDto;
import fra.konyang.mid17681008.admin.web.dto.MembersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MembersService {
    public final MembersRepository membersRepository;

    @Transactional
    public Long save(MembersSaveRequestDto requestDto) {
        return membersRepository.save(requestDto.toEntity()).getNum();
    }

    @Transactional
    public Long update(Long num, MembersUpdateRequestDto requestDto){
        Members members = membersRepository.findById(num)
                .orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다. num = " + num));

        members.update(requestDto.getId(), requestDto.getName(), requestDto.getPass(), requestDto.getEmail());
        return num;
    }


    @Transactional
    public MembersResponseDto findById(Long num){
        Members entity = membersRepository.findById(num)
                .orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다. num = " + num));
        return new MembersResponseDto(entity);
    }
    @Transactional
    public List<MembersListResponseDto> findAllAsc() {
        return membersRepository.findAll().stream()
                .map(MembersListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long num){
        Members members = membersRepository.findById(num)
                .orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다. num=" + num));
        membersRepository.delete(members);
    }


}
