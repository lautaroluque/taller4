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

  checkLogin() 
  {
    if (this.loginservice.logIn(this.username, this.password)) 
    {
      this.router.navigate(['notas']);
    }
    else
    {
      alert("Login incorrecto");
    }
  }
  goToRegister() {
    this.router.navigate(['registro']);
  }
}
