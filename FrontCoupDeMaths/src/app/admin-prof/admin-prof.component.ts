import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { User } from '../interfaces/user.interface';

@Component({
  selector: 'app-admin-prof',
  templateUrl: './admin-prof.component.html',
  styleUrls: ['./admin-prof.component.scss']
})
export class AdminProfComponent implements OnInit {
  professors: any[] = []; // Assurez-vous de mettre le type correct si possible

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.adminService.getAllProfessors().subscribe({
      next: (data: any[]) => {
        this.professors = data;
      },
      error: (error) => {
        console.error('Error fetching professors:', error);
      },
    });
}
activerProfessor(professorId: number): void {
  this.adminService.activeUser(professorId).subscribe({
    next: (data:User) => {
      // Traitez la réponse si nécessaire
      console.log('Professeur activé avec succès:', data);
      // Vous pouvez également mettre à jour votre liste de professeurs ici si nécessaire
    },
    error: (error) => {
      console.error('Erreur lors de l\'activation du professeur:', error);
    },
  });
}
}
