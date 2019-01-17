import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  onSignUp(form: NgForm) {
      const email = form.value.email;
      const password = form.value.password;
      const username = form.value.username;
      const firstname = form.value.firstName;
      const lastname = form.value.lastName;
      const photo_url: string = "https://static.licdn.com/scds/common/u/images/themes/katy/ghosts/person/ghost_person_200x200_v1.png";
      console.log(firstname);
      console.log(lastname);
      console.log(photo_url);
      console.log("hello there")
      this.authService.signUpUserFireBase(email, password,username,firstname,lastname, photo_url);

      
  }

}
