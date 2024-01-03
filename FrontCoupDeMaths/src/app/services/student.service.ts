import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user.interface';
import { environment } from 'src/environments/environment.development';
import { Student } from '../interfaces/student.interface';
import { Question } from '../interfaces/question.interface';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient, 
              private authService: AuthService) { }

  /*  STUDENT  */
  public getFindById = (studentId: number|undefined): Observable<Student> => {
    const headers = this.authService.getHeaders();
    return (this.http.get<Student>(environment.API_URL + `api/student/${studentId}`,  {headers} ));
  }

  /*  QUESTIONS  */
  public findQuestionById = (id: string|null): Observable<any> => {
    const headers = this.authService.getHeaders();
    return this.http.get<any>(environment.API_URL + 'api/student/questions/' + id, { headers })
  }

  public updateQuestionById = (questionId: string|null, question: FormData): Observable<Student> => {
    console.log("Question",question.get('question'));
    const headers = this.authService.getHeaders();
    return (this.http.put<Student>(environment.API_URL + `api/student/questions/${questionId}`, question, {headers} ));
  }

  public deleteQuestionById = (questionId: number|undefined): Observable<Question> => {
    const headers = this.authService.getHeaders();
    return (this.http.delete<Question>(environment.API_URL + `api/student/questions/${questionId}`,  {headers} ));
  }

  

}

