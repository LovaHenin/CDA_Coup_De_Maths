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
   private Long questionId;
   private QuestionDto question;
    private Long professorId;
   private ProfessorDto professor;
   private List<DocResponseDto> docs;

}
