import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { User } from '../interfaces/user.interface';

@Component({
  selector: 'app-admin-eleve',
  templateUrl: './admin-eleve.component.html',
  styleUrls: ['./admin-eleve.component.scss']
})
export class AdminEleveComponent implements OnInit {
  students: any[] = []; 
constructor(private adminService: AdminService){}

ngOnInit(): void {
  this.adminService.getAllStudent().subscribe({
    next: (data: any[]) => {
      this.students = data;
    },
    error: (error) => {
      console.error('Error fetching students:', error);
    },
  });
}
activerEtudiant(studentId: number): void {
  this.adminService.activeUser(studentId).subscribe({
    next: (data: User) => {
      // Traitez la réponse si nécessaire
      console.log('Utilisateur activé avec succès:', data);
      // Vous pouvez également mettre à jour votre liste d'étudiants ici si nécessaire
    },
    error: (error) => {
      console.error('Erreur lors de l\'activation de l\'utilisateur:', error);
    },
  });
}

}
