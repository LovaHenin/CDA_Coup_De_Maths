import { Injectable } from '@angular/core';
import { User } from '../interfaces/user.interface';
import { environment } from 'src/environments/environment.development';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { UserForAdmin } from '../interfaces/user-for-admin.interface';




@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient, 
              private authService: AuthService
              ) {}

  public getAllStudent = (): Observable<User[]> => {
    const headers = this.authService.getHeaders();
    return (this.http.get<User[]>(environment.API_URL + 'api/admin/students/simple',  {headers} ));
  }
  public getAllProfessors = (): Observable<UserForAdmin[]> => {
    const headers = this.authService.getHeaders();
    return (this.http.get<UserForAdmin[]>(environment.API_URL + 'api/admin/professors',  {headers} ));
  }

  public activeUser = (userId: number): Observable<User> => {
    const headers = this.authService.getHeaders();
    const url = `${environment.API_URL}api/admin/users/${userId}/role`; 
    return this.http.put<User>(url, null, { headers });
  }
}
