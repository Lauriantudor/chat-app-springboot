import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
user=new User();
msg = '';
  constructor(private _service: RegistrationService, private _router: Router) { }

  ngOnInit(): void {
  }
  gotologin(){
    this._router.navigate(['']);
  }
  registerUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
      data => {
        console.log("Response received");
        this._router.navigate(['chat']);
        this.msg = "Register succefully";
      },
      error => {
        console.log("Error occurred");
        this.msg = error.error;
      }
    )
  }


}
