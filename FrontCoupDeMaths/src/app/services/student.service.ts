import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user.interface';
import { environment } from 'src/environments/environment.development';
import { Student } from '../interfaces/student.interface';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient, 
    private authService: AuthService) { }

  public getFindById = (studentId: number|undefined): Observable<Student> => {
    const headers = this.authService.getHeaders();
    return (this.http.get<Student>(environment.API_URL + `api/student/${studentId}`,  {headers} ));
  }
}

