package com.simplon.coupdemaths.dto;

import java.util.List;

public record ProfessorDto(
        Long id,
        String name,
        String email,
        String password,
        int credits,
        List<ResponseDto> responses,
        List<TransactionDto> transactions,
        List<DocDiplomeDto> docDiplomes
) {
}
