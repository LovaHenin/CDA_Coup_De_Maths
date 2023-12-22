import { Component, OnInit } from '@angular/core';
import { StudentService } from '../services/student.service';
import { User } from '../interfaces/user.interface';
import { Student } from '../interfaces/student.interface';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-page-student',
  templateUrl: './page-student.component.html',
  styleUrls: ['./page-student.component.scss']
})
export class PageStudentComponent implements OnInit {
  student!: Student;
  studentId: number = 0;

  constructor(private studentService: StudentService,
    private auth: AuthService
    ) { }

  ngOnInit(): void {

    // Vérifiez si studentId est défini avant d'appeler le service
    this.studentService.getFindById(this.auth.getUser()?.id).subscribe({
      next: (data) => {
        console.log('Utilisateur choisi n°', this.studentId, data);
        this.student = data;
      },
      error: (error: Error) => console.error('Error fetching student:', error)
    });
  }

}

