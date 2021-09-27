import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {UserCreateModel} from "../user-create.model";
import {UserApiService} from "../user-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: ['./user-new.component.scss']
})
export class UserNewComponent implements OnInit {

  formUser = new FormGroup({
    email: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    birthDay: new FormControl(),
  });

  constructor(private _userService: UserApiService, private _router: Router) { }

  ngOnInit(): void { }

  create() {
    console.log(this.formUser.value);
    const newUser = this.formUser.value as UserCreateModel;
    this._userService.create(newUser).subscribe(value => {
      this._router.navigateByUrl('/users');
    });
  }
}
