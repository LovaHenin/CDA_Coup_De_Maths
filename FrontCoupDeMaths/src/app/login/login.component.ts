import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(protected authService: AuthService,
    private router: Router
  ) { }


  login = (formLogin: NgForm) => {
    console.log(formLogin.value);
    if (formLogin.valid) {
      this.authService.login(formLogin).subscribe({
        next: (data) => {
          console.log('Utilisateur: ', data.user);
          //console.log('token: ', data.token);
          // Enregistre le token et redirige vers la page d'acceuil
          this.authService.doLogged(data);

          // redirection
          this.authService.redirectByRole();
        },
        error: (errors: Error) => {
          //console.log('Observer got an error: ', errors);
          //  this.checkDataConstraints(errors);
        },
        complete: () => console.log('Observer got a complete notification'),
      });
    }
  }


  
}
