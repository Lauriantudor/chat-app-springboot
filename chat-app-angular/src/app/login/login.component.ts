import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
user = new User();
msg = '';
  constructor(private _service: RegistrationService, private _router: Router) { }

  ngOnInit(): void {
  }
  loginUser(){
    this._service.loginUserFormRemote(this.user).subscribe(
      data =>{
        console.log("You are login");
        this._router.navigate(['chat']);
        this.user=  data;
      },
      error =>{
        console.log("Bed crandetials");
        this.msg ="Bed crandetials";
      }
    )
  }
  gotoragistration(){
    this._router.navigate(['registration'])
  }
}
