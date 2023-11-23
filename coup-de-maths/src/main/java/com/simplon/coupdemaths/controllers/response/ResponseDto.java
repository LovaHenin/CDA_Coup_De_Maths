package com.simplon.coupdemaths.controllers.response;

import com.simplon.coupdemaths.controllers.doc.DocResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseDto(
        int id,
        String response,
        LocalDateTime responseDate,

        List<DocResponseDto> docs

) {
}
