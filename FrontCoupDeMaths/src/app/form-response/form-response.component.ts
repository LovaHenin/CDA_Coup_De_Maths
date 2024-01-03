import { Component, OnInit } from '@angular/core';

import { AuthService } from '../services/auth.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ResponseService } from '../services/response.service';
import { Question } from '../interfaces/question.interface';
import { ProfessorService } from '../services/professor.service';

@Component({
  selector: 'app-form-response',
  templateUrl: './form-response.component.html',
  styleUrls: ['./form-response.component.scss']
})
export class FormResponseComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private professorService: ProfessorService
  ) {}

  selectedFile!: File;
  professorId: number | undefined = 0;
  questionId!: string | null;

  question!: Question;

  ngOnInit(): void {
    this.questionId = this.route.snapshot.paramMap.get('questionId');
    // Au chargement du composant, récupérez les informations de l'utilisateur
    // this.professorId = this.authService.getUser()?.id; // Assurez-vous d'ajuster cela selon la structure de vos données utilisateur
    this.getQuestionById();
  }

  handleFileInput(event: any): void {
    const file = event.target.files[0];

    if (file) {
      // Accéder au fichier sélectionné à partir de l'événement
      this.selectedFile = event.target.files[0];
    }
  }

  getQuestionById = () => {
    this.professorService.getQuestionById(this.questionId).subscribe({
      next: (data) => {
        this.question = data;
      },
      error: (err:Error) => {

      }
      
    })
  }

  onSubmit(formResponse: NgForm): void {
    // Convertir l'ID du professeur en chaîne de caractères
    const professorIdToString = this.authService.getUser()?.id.toString();
    let professorId: string = "";

    if (professorIdToString) {
      professorId = professorIdToString;
    }

    // Convertir l'ID de la question en chaîne de caractères
    const questionIdToString = this.questionId?.toString();
    let questionId: string = "";
    if (questionIdToString) {
      questionId = questionIdToString;
    }

    const formData = new FormData();
    formData.append('response', formResponse.value.response);
    formData.append('documentFile', this.selectedFile);
    formData.append('documentName', this.selectedFile.name);
    formData.append('professorId', professorId);
    formData.append('questionId', questionId);

    this.professorService.createResponse(formData).subscribe({
      next: (response) => {
        this.router.navigate(["/user/professor"]);
        console.log('Réponse créée avec succès :', response);
      },
      error: (err: Error) => console.log('Observer got an error: ' + err),
    });
  }
}
