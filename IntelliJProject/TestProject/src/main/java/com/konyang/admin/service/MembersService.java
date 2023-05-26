package com.konyang.admin.service;

import com.konyang.admin.domain.members.Members;
import com.konyang.admin.domain.members.MembersRepository;
import com.konyang.admin.web.dto.MembersSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository membersRepository;

    @Transactional
    public Long save(MembersSaveRequestDto requestDto) {
        return membersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<Members> findAllAsc() {
        return membersRepository.findAll();
    }
}
