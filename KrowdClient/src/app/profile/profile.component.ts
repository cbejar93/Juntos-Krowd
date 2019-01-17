import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
import { DataServiceService } from '../data-service.service';
import { AuthService } from '../landing/auth/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user : {id: string, photo: string, firstname: string, lastname: string, tokenscore: number}
  userID: number;

  constructor(private router: Router, private dataService: DataServiceService, private authService: AuthService) { }

  ngOnInit() {
    
    this.userID =this.authService.getCurrentUser();
    console.log(`from profile comp ${this.userID}`)
    this.getUserInfo(this.userID);
  }

  getUserInfo(uID) {
    this.dataService.getUserById(uID).subscribe(data=>
      {

      // this.user = {
      //     id: this.userID,
      //     photo: data.photo_url,
      //     firstname: data.firstname,
      // }  
      console.log("hello there");
      })
  }

}

// {userid: 983, firstname: null, lastname: null, username: "natesnake", email: "natesnake@test.com", …}
// email: "natesnake@test.com"
// fID: "eKIuVqQldChNOPPDBHKDpwDm8mQ2"
// firstname: null
// lastname: null
// password: "natesnake"
// photo_url: null
// token_score: 0
// userid: 983
// username: "natesnake"
