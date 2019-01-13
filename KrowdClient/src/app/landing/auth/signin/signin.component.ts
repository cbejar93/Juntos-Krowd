import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor( private auth: AuthService) { }

  ngOnInit() {
  }

  onSignIn(form: NgForm) :void{
      const username = form.value.username;
      const password = form.value.password;
      this.auth.signInUser(username, password);
  }

}