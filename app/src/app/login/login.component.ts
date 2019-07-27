import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private router: Router, private loginservice: LoginService) { }

  ngOnInit() { }

  login(){
    this.loginservice.logIn(this.username, this.password).subscribe(userData => {
      sessionStorage.setItem('username',this.username);
      let tokenStr= 'Bearer '+userData.token;
      sessionStorage.setItem('token', tokenStr);
      this.router.navigate(['notas']);
     });
  }

  goToRegister() {
    this.router.navigate(['registro']);
  }
}
