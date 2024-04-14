import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdminModule} from "./admin.module";
import {AdminComponent} from "./admin.component";
import {UsersPageComponent} from "./users-page/users-page.component";
import {DocumentComponent} from "../document/document.component";

const routes: Routes = [
  {path:'', component: AdminComponent,
    children: [
      {path: '', component: UsersPageComponent },
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
