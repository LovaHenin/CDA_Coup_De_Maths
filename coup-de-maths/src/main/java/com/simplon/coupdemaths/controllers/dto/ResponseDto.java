package com.simplon.coupdemaths.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private String response;
    private LocalDateTime responseDate;
    private QuestionDto question;
    private List<DocResponseDto> docs;
    private ProfessorDto professor;
}
