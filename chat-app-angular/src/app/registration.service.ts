import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http: HttpClient) { }

  public loginUserFormRemote(user: User):Observable<any>{
    return this._http.post<any>("http://localhost:8091/login",user);
  }

  public registerUserFromRemote(user: User):Observable<any>{
    return this._http.post<any>("http://localhost:8091/registeruser",user);
  }
  public listUsersFromRemote():Observable<Array<User>>{
    return this._http.get<Array<User>>("http://localhost:8091/users");
  }
  public selectUserFromRemote(id:number):Observable<any>{
    return this._http.post<any>("http://localhost:8091/user/",id);
  }
}
