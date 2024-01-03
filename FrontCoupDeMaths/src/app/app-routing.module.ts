import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { AdminEleveComponent } from './admin-eleve/admin-eleve.component';
import { AdminProfComponent } from './admin-prof/admin-prof.component';
import { AdminComponent } from './admin/admin.component';
import { PageStudentComponent } from './page-student/page-student.component';
import { PageProfComponent } from './page-prof/page-prof.component';
import { FormQuestionComponent } from './form-question/form-question.component';
import { FormResponseComponent } from './form-response/form-response.component';

const routes: Routes = [
  { path: '', component:HomeComponent },
  {path:'inscription', component: InscriptionComponent},
  {path:'login', component:LoginComponent},
  {path:'user/student', component:PageStudentComponent},
  {path:'user/professor', component:PageProfComponent},
  {path:'admin/student', component:AdminEleveComponent},
  {path:'admin/professor', component:AdminProfComponent},
  {path:'user/admin', component:AdminComponent},
  {path:'user/student/question', component: FormQuestionComponent},
  {path:'user/student/question/:id', component: FormQuestionComponent},
  {path:'user/professor/response/:questionId', component: FormResponseComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
