import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { UserModelService } from 'src/app/user-model.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import * as firebase from 'firebase';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
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
  } = null;

  userID:number;

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient, private router: Router) { }

  signUpUserFireBase(email: string, password: string, username: string, firstname: string, lastname: string, photo_url: string) {
      firebase.auth().createUserWithEmailAndPassword(email, password)
        .then(res => {
          console.log("hello from firebase sign in ");
        console.log(res.user.uid);
        let firedID: string = res.user.uid;
        
        this.signUpUser(username, email, password, firedID, firstname, lastname, photo_url);
        this.router.navigate(['/landing/signin']);
        
  })
        .catch(error => console.log(error));
  }

  signUpUser(username: string, email:string, password: string, fireID: string, firstname: string, lastname: string, photo_url: string) {
    console.log(fireID);
    console.log(firstname);
    console.log(lastname);
    console.log(photo_url);
    this.http.post('http://localhost:8080/Krowd/user/add', { 'username':username,'password': password, 'email': email,'fID': fireID, 'firstname': firstname, 'lastname': lastname, 'photo_url': photo_url }).subscribe((event) => console.log(event));

  }

  getUserbyFID(fid: string){
    console.log("running getUserbyFID")
    return this.http.get(`http://localhost:8080/Krowd/user/fid/${fid}`)
  }

  signInUserFirebase(email: string, password:string, username: string ){
    firebase.auth().signInWithEmailAndPassword(email,password)
      .then(
        response=>{
          console.log(response);
          let fID: string= response.user.uid;
          this.signInUser(username, password, email, fID);
          this.getUserbyFID(fID)
          .subscribe(data=>
            {
              console.log("hello from after fbaseiduser");
              console.log(data);
              console.log(data[0].userid);
              this.userID = data[0].userid;
              console.log(this.userID);
        
            })
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

  getCurrentUser(){
    return this.userID;
  }

  isAuthenticated() {
    return this.tk != null;  
  }

  logOut() {
    firebase.auth().signOut;
    this.tk = null;
  }

}
