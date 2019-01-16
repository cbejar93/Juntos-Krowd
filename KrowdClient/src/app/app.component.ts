import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
import * as firebase from 'firebase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'KrowdClient';
  routeURL: string;
  isNotLandingPage: boolean=true;

  constructor(private router: Router ) {

  }

  ngOnInit(){
      firebase.initializeApp({
        apiKey: "AIzaSyDWgmBV5Nr1fNkjNkr0_SHJn9E7sC0Ocx4",
        authDomain: "krowd-986c0.firebaseapp.com"
      });
  }

  letsTryThis(){

    this.routeURL= this.router.url;
    if(this.routeURL==="/landing"){
      this.isNotLandingPage=false;
    }
    else if (this.routeURL==="/landing/signin"){
      this.isNotLandingPage=false;
    }
    else if (this.routeURL==="/landing/signup"){
      this.isNotLandingPage=false;
    }
    else{
      this.isNotLandingPage=true;
    }
    // console.log(this.routeURL);
    return this.isNotLandingPage;
  }
 

}
