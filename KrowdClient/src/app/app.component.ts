import { Component } from '@angular/core';
import {Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'KrowdClient';
  routeURL: string;
  isNotLandingPage: boolean=true;

  constructor(private router: Router ) {
  


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
