import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor(private router: Router, protected authService: AuthService) { }

  // Deconnexion et redirection vers la page d'acceuil
  logout() {
    this.authService.doLogout();
    // Redirige vers la page d'accueil après la déconnexion
  this.router.navigate(['/']);
  }
}
