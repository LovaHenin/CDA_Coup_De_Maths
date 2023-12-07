package com.simplon.coupdemaths.repositories.doc;

import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "document_response")
public class DocResponseRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String documentName;
    @Column(name = "path")
    private String documentPath;

    @ManyToOne
    @JoinColumn(name = "response_id")
    private ResponseRepositoryModel response;

}
