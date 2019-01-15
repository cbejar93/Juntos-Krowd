import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { UserModelService } from 'src/app/user-model.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient, private router: Router) { }

  signUpUser(username: string, password: string) {
    this.http.post('http://localhost:8080/Krowd/login', { username, password }).subscribe((event) => console.log(event));

  }

  signInUser(username, password) {

    this.http.post('http://localhost:8080/Krowd/login/sent', { 'username': username, 'password': password })
      .subscribe((event) => this.router.navigate(['/home']));





  }

  isAuthenticated() {
    // return this.user != null;

    return false;
  }

  logOut() {



  }
}
