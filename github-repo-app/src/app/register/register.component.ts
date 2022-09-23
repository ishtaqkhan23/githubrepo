import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { RegitrationServiceService } from '../regitration-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public user: User = { username: '', email: '', password: '' };
  constructor(private registerService: RegitrationServiceService, private router: Router) { }

  ngOnInit() {
  }
  register() {
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe();
    this.router.navigate(['/login']);
  }

}
