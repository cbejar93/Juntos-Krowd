import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { UserModelService } from 'src/app/user-model.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) { }

  signUpUser(username: string, password: string) {
    this.http.post('http://localhost:8080/Krowd/login', { username, password }).subscribe((event) => console.log(event));

  }

  signInUser(form) {

    this.http.post('http://localhost:8080/Krowd/login', form.value)

      .subscribe((event) =>
        this.router.navigate(['/home']));

  }

  isAuthenticated() {
    // return this.user != null;
    return false;
  }

  logOut() {

  }
}
