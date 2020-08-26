import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from "./person/person.component";
import { AddPersonComponent } from "./person/add-person/add-person.component";
import { EditPersonComponent } from "./person/edit-person/edit-person.component";
import { AuthComponent } from "./auth/auth.component";

const routes: Routes = [
  { path:'', component: AuthComponent},
  {path:'person', component: PersonComponent },
  { path:'addperson', component: AddPersonComponent},
  { path:'editperson/:id', component: EditPersonComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
