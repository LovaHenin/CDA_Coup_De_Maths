package com.simplon.coupdemaths.dto;

import com.simplon.coupdemaths.dto.DocResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseDto(
        Long id,
        String response,
        LocalDateTime responseDate,

        List<DocResponseDto> docs

) {
}
