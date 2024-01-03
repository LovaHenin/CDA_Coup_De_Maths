import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { Question } from '../interfaces/question.interface';
import { ProfessorService } from '../services/professor.service';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-page-prof',
  templateUrl: './page-prof.component.html',
  styleUrls: ['./page-prof.component.scss']
})
export class PageProfComponent implements OnInit{
  question: any; 
  url_upload = environment.API_URL + 'upload/';
  questions: Question[] = [];

  constructor(
    private professorService: ProfessorService,
    private route: ActivatedRoute,
    protected auth: AuthService
  ) { }

  ngOnInit(): void {
    this.loadQuestionsForProfessor();
  }

  loadQuestionsForProfessor(): void {
    this.professorService.getAllQuestions().subscribe({
      next: (questions: Question[]) => {
        this.questions = questions;
        console.log('Questions récupérées avec succès :', questions);
      },
      error: (err: Error) => console.log('Une erreur s\'est produite lors de la récupération des questions : ' + err),
    });
  }

}
