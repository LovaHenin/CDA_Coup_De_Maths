import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { User } from '../interfaces/user.interface';
import { UserForAdmin } from '../interfaces/user-for-admin.interface';

@Component({
  selector: 'app-admin-eleve',
  templateUrl: './admin-eleve.component.html',
  styleUrls: ['./admin-eleve.component.scss']
})
export class AdminEleveComponent implements OnInit {
  students: UserForAdmin[] = []; 
constructor(private adminService: AdminService){}

ngOnInit(): void {
  this.refresh();
}
activerEtudiant(studentId: number): void {
  this.adminService.activeUser(studentId).subscribe({
    next: (data: User) => {
      // Traitez la réponse si nécessaire
      console.log('Utilisateur activé avec succès:', data);
     // Rafraichi la page
     this.refresh();
   
    },
    error: (error) => {
      console.error('Erreur lors de l\'activation de l\'utilisateur:', error);
    },
  });
}


refresh = () => {
  this.adminService.getAllStudent().subscribe({
    next: (data: UserForAdmin[]) => {
      this.students = data;
    },
    error: (error) => {
      console.error('Error fetching professors:', error);
    },
  });
}

}
