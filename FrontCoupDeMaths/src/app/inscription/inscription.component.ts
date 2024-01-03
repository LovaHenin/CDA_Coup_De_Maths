import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { NgForm } from '@angular/forms';
import { TypeUserEnum } from '../type-user-enum';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss'],
})
export class InscriptionComponent {
  checbockBoxSelected: TypeUserEnum = 1;

  constructor(protected authService: AuthService) { }

  onItemChange = (s: string) => {
    if (s === 'Professor') this.checbockBoxSelected = TypeUserEnum.PROFESSOR;
    else this.checbockBoxSelected = TypeUserEnum.STUDENT;
    console.log("type", this.checbockBoxSelected);
  }

  registration = (formRegister: NgForm) => {
    // POST :  findAll
    if (formRegister.valid){
      console.log("registration", formRegister.value);

      this.authService.registration(this.checbockBoxSelected, formRegister).subscribe({
        next: (data) => {
          console.log("registration retour", data);
          //console.log('Utilisateur: ', data.user);
          //console.log('token: ', data.token);
          // Enregistre le token et redirige vers la page d'acceuil
          this.authService.doLogged(data);
        },
        error: (errors: Error) => {
          //console.log('Observer got an error: ', errors);
          //  this.checkDataConstraints(errors);
        },
        complete: () => console.log('Observer got a complete notification'),
      })
    }
  }
}
