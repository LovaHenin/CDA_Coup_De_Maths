import { Component, OnInit } from '@angular/core';
import { StudentService } from '../services/student.service';
import { User } from '../interfaces/user.interface';
import { Student } from '../interfaces/student.interface';
import { AuthService } from '../services/auth.service';
import { environment } from 'src/environments/environment.development';
import { Question } from '../interfaces/question.interface';

@Component({
  selector: 'app-page-student',
  templateUrl: './page-student.component.html',
  styleUrls: ['./page-student.component.scss']
})
export class PageStudentComponent implements OnInit {
  student!: Student;
  studentId: number = 0;
  url_upload = environment.API_URL + 'upload/';
  question!: Question;


  constructor(
    private studentService: StudentService,
    private auth: AuthService
  ) { }

  ngOnInit(): void {

    // Vérifiez si studentId est défini avant d'appeler le service
    this.studentService.getFindById(this.auth.getUser()?.id).subscribe({
      next: (data) => {
        // console.log('Utilisateur choisi n°', this.studentId, data);
        this.student = data;
      },
      error: (error: Error) => console.error('Error fetching student:', error)
    });
  }

  // delete = (id: number) => {
  //   // Vérifiez si studentId est défini avant d'appeler le service
  //   this.studentService.deleteQuestionById(this.auth.getUser()?.id).subscribe({
  //     next: (data) => {
  //       console.log('Utilisateur choisi n°', this.studentId, data);
  //     },
  //     error: (error: Error) => console.error('Error fetching student:', error)
  //   });
  // }
  delete = (questionId: number) => {
    // Utilisez le bon ID pour la question
    this.studentService.deleteQuestionById(questionId).subscribe({
      next: (data) => {
        console.log('Question supprimée avec succès:', data);
        // Actualisez la liste des questions après la suppression
        this.student?.questions?.splice(
          this.student.questions.findIndex((q) => q.id === questionId),
          1
        );
      },
      error: (error: Error) => console.error('Erreur lors de la suppression de la question:', error)
    });
  }
  
}

