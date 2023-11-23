package com.simplon.coupdemaths.controllers.professor;

import com.simplon.coupdemaths.controllers.doc.DocDiplomeDto;
import com.simplon.coupdemaths.controllers.response.ResponseDto;
import com.simplon.coupdemaths.controllers.transaction.TransactionDto;

import java.util.List;

public record ProfessorDto(
        int id,
        String name,
        String email,
        String password,
        int credits,
        List<ResponseDto> responses,
        List<TransactionDto> transactions,
        List<DocDiplomeDto> docDiplomes
) {
}
