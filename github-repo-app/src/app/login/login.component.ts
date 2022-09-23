import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  token: string;
  errorMessage: string;
  constructor(private loginService: LoginService, private router: Router) { }

  login() {
    this.errorMessage = '';
    this.loginService.login(this.username, this.password).subscribe(data => {
      this.token = data;
      sessionStorage.setItem('token', this.token);
      sessionStorage.setItem('username', this.username);
      console.log('data ' + this.token);
      this.router.navigate(['/repository']);
    },
      (error) => this.errorMessage = error);
  }

}
