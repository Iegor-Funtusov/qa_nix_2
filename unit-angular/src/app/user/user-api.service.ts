import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

import { environment } from '../../environments/environment'
import {Observable} from "rxjs";
import {UserModel} from "./user.model";
import {map} from "rxjs/operators";
import {UserCreateModel} from "./user-create.model";

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  private url = environment.apiUrl;

  constructor(private _http: HttpClient) { }

  findAll(): Observable<any> {
    return this._http.get(this.url + '/users', {}).pipe(
      map((res: any) => {
        console.log(res);
        return res.data;
      })
    )
  }

  delete(id: string):Observable<any> {
    return this._http.delete(this.url + '/users/' + id, {}).pipe(
      map((res: any) => {
        return res.data;
      })
    )
  }

  create(user: UserCreateModel) {
    return this._http.post(this.url + '/users/', user).pipe(
      map((res: any) => {
        return res.data;
      })
    )
  }
}
