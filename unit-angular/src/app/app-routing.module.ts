import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserItemsComponent} from "./user/user-items/user-items.component";
import {UserDetailsComponent} from "./user/user-details/user-details.component";
import {UserNewComponent} from "./user/user-new/user-new.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'users',
    pathMatch: 'full'
  },
  {
    path: 'users',
    component: UserItemsComponent
  },
  {
    path: 'users/details/:id',
    component: UserDetailsComponent
  },
  {
    path: 'users/new',
    component: UserNewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
