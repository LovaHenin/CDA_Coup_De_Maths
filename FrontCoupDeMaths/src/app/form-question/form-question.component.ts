import { Component, OnInit } from '@angular/core';
import { TypeQuestion } from '../enums/type-question';
import { Level } from '../enums/level';
import { QuestionService } from '../services/question.service';
import { AuthService } from '../services/auth.service';
import { NgForm } from '@angular/forms';
import { Question } from '../interfaces/question.interface';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../services/student.service';


@Component({
  selector: 'app-form-question',
  templateUrl: './form-question.component.html',
  styleUrls: ['./form-question.component.scss']
})
export class FormQuestionComponent implements OnInit {

  constructor(
    private questionService: QuestionService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private studentService: StudentService
  ) { }

  selectedFile!: File;
  selectedImage: string = '';

  studentId: number | undefined = 0;

  question: Question = {
    id: 0,
    question: "",
    level: "",
    questionType: "",
    questionDate: "",
    studentId: null,
    student: null
  };
  questionId!:string|null;

  // questionData!: Question;

  levels = Object.values(Level).filter(value => typeof value === 'string');

  questionTypes = Object.values(TypeQuestion).filter(value => typeof value === 'string');


  ngOnInit(): void {
    // Au chargement du composant, récupérez les informations de l'utilisateur
    this.studentId = this.authService.getUser()?.id; // Assurez-vous d'ajuster cela selon la structure de vos données utilisateur
    console.log(this.studentId);
    console.log(this.levels);
    if(this.route.snapshot.paramMap.get("id")!= null) {
      this.questionId = this.route.snapshot.paramMap.get("id");
      this.questionById(this.questionId);
    }
    

  }

  handleFileInput(event: any): void {
    const file = event.target.files[0];

    if (file) {
      // Accéder au fichier sélectionné à partir de l'événement
      this.selectedFile = event.target.files[0];
    }
  }

  onSubmit(formQuestion: NgForm): void {
    const formData = new FormData();

    formData.append('question', formQuestion.value.question);
    formData.append('level', formQuestion.value.level);
    formData.append('questionType', formQuestion.value.questionType);
    if(this.selectedFile){
      formData.append('documentFile', this.selectedFile);
      formData.append('documentName', this.selectedFile.name);
    }
    
    if (this.questionId != null) {
      // mode PUT
      this.studentService.updateQuestionById(this.questionId, formData).subscribe({
        next: (response) => {
          if(response){
            this.router.navigate(["/user/student"]);
          console.log('Question modifié avec succès :', response);
          }
        },
        error: (err: Error) => console.log('Observer got an error: ' + err),
      })
    } else {
      // mode POST
      const studentIdToString = this.studentId?.toString();
      if (studentIdToString) {
        formData.append('studentId', studentIdToString);
      }
      this.questionService.createQuestion(formData).subscribe({
        next: (response) => {
          this.router.navigate(["/user/student"]);
          console.log('Question créée avec succès :', response);
        },
        error: (err: Error) => console.log('Observer got an error: ' + err),
      })
    }
  }

  questionById = (id: string | null) => {
    this.studentService.findQuestionById(id).subscribe({
      next: (response) => {
        this.question = response;
        console.log('Question : ', this.question);
      },
      error: (err: Error) => console.log('Observer got an error: ' + err),
    })
  }

}
