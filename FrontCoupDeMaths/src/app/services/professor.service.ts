import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Question } from '../interfaces/question.interface';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  constructor(private http: HttpClient,
    private authService: AuthService) { }

    /*  RESPONSE  */
  public createResponse = (responseData: FormData): Observable<any> => {
    const headers = this.authService.getHeaders();
    return this.http.post(environment.API_URL + 'api/professor/responses', responseData, { headers });
  }

  /*  QUESTIONS  */
  // Méthode pour récupérer toutes les questions pour un professeur
  public getAllQuestions(): Observable<Question[]> {
    const headers = this.authService.getHeaders();
    return this.http.get<Question[]>(environment.API_URL + 'api/professor/questions', { headers });
  }

  public getQuestionById = (id: string | null): Observable<Question> => {
    const headers = this.authService.getHeaders();
    return this.http.get<Question>(environment.API_URL + 'api/professor/questions/' + id, { headers })
  }
}
