import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  API_URL = environment.API_URL + 'api/student/questions';

  createQuestion = (questionData: FormData): Observable<any> => {
    const headers = this.authService.getHeaders();
    return this.http.post(this.API_URL, questionData, {headers} );
  }

  
}
