import { Component, OnInit } from '@angular/core';
import {UserApiService} from "../user-api.service";
import {UserModel} from "../user.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-items',
  templateUrl: './user-items.component.html',
  styleUrls: ['./user-items.component.scss']
})
export class UserItemsComponent implements OnInit {

  users: UserModel[] | undefined;

  constructor(private _userService: UserApiService, private _router: Router) { }

  ngOnInit(): void {
    this._userService.findAll().subscribe(users => {
      this.users = users;
    })
  }

  delete(id: string) {
    this._userService.delete(id).subscribe(() => {
      location.reload();
    })
  }

  create() {
    this._router.navigateByUrl('/users/new');
  }
}
