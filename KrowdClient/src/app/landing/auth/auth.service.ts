import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { UserModelService } from 'src/app/user-model.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import * as firebase from 'firebase';
import { tokenKey } from '@angular/core/src/view';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  tk: string; 
  firebaseID: string;
  currentUser:{
    ctk: string,
    cUserID: number
  }

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient, private router: Router) { }

  signUpUserFireBase(email: string, password: string, username: string) {
      firebase.auth().createUserWithEmailAndPassword(email, password)
        .then(res => {this.router.navigate(['/landing/signin']);
        console.log(res.user.uid);
        let firedID: string = res.user.uid;
        this.signUpUser(username, email, password, firedID);
  })
        .catch(error => console.log(error));
  }

  signUpUser(username: string, email:string, password: string, fireID: string) {
    console.log(fireID);
    this.http.post('http://localhost:8080/Krowd/user/add', { 'username':username,'password': password, 'email': email,'fID': fireID }).subscribe((event) => console.log(event));

  }

  signInUserFirebase(email: string, password:string, username: string ){
    firebase.auth().signInWithEmailAndPassword(email,password)
      .then(
        response=>{
          console.log(response);
          let fID: string= response.user.uid;
          this.signInUser(username, password, email, fID);
          firebase.auth().currentUser.getIdToken().then(
             (token:string)=>
              this.tk= token


          )
        }
      )
      .catch(error=>console.log(error))
  }

  signInUser(username, password, email, fID) {

    this.http.post('http://localhost:8080/Krowd/login/sent', { 'username': username, 'password': password, 'email': email, 'fID': fID })
      .subscribe((event) => this.router.navigate(['/home']));
  }

  getToken(){
    firebase.auth().currentUser.getIdToken().then(
      (token:string)=>
       this.tk= token

   )
  }

  isAuthenticated() {
    return this.currentUser.ctk != null;  
  }

  logOut() {
    firebase.auth().signOut;
    this.tk = null;
  }

}
