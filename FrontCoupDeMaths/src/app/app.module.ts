import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BestSellerComponent } from './best-seller/best-seller.component';

import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { AdminEleveComponent } from './admin-eleve/admin-eleve.component';
import { AdminProfComponent } from './admin-prof/admin-prof.component';
import { AdminComponent } from './admin/admin.component';
import { PageProfComponent } from './page-prof/page-prof.component';
import { PageStudentComponent } from './page-student/page-student.component';
import { FormsModule } from '@angular/forms';  // Gestion de formulaire lié a ngModel+ajout dans inmport
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { FormQuestionComponent } from './form-question/form-question.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BestSellerComponent,
    InscriptionComponent,
    LoginComponent,
    AdminEleveComponent,
    AdminProfComponent,
    AdminComponent,
    PageProfComponent,
    PageStudentComponent,
    NavbarComponent,
    FooterComponent,
    FormQuestionComponent
  ],
  imports: [
    MatIconModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
