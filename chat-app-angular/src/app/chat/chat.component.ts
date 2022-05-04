import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginComponent } from '../login/login.component';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  user: Array<User>=[];
  user1= new User();
  constructor(private _service: RegistrationService) { }

  ngOnInit(): void {
    this._service.listUsersFromRemote().subscribe(
      data =>{console.log(data)
              this.user = data 
      }, error=> {console.log(error)}
      
    );
  }
  selectUser(id: number){
    this._service.selectUserFromRemote(id).subscribe(
      data =>{console.log(data);
        this.user1 = data
      }, error=>{console.log(error)}
    )
  }

}
