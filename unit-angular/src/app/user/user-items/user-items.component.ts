import { Component, OnInit } from '@angular/core';
import {UserApiService} from "../user-api.service";
import {UserModel} from "../user.model";

@Component({
  selector: 'app-user-items',
  templateUrl: './user-items.component.html',
  styleUrls: ['./user-items.component.scss']
})
export class UserItemsComponent implements OnInit {

  users: UserModel[] | undefined;

  constructor(private _userService: UserApiService) { }

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
}
