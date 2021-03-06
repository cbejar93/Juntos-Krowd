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
  user : {id: number, photo: string, firstname: string, lastname: string, tokenscore: number}
  userID: number;

  constructor(private router: Router, private dataService: DataServiceService, private authService: AuthService) { }

  ngOnInit() {
    
    this.userID =this.authService.getCurrentUser();
    console.log(`from profile comp ${this.userID}`)
    this.getUserInfo(this.userID);
  }

  getUserInfo(uID) {
    this.dataService.getUserById(uID)
    .subscribe((data)=>
      {

      this.user = {
          id: this.userID,
          photo: data["photo_url"],
          firstname: data["firstname"],
          lastname: data["lastname"],
          tokenscore: 3
      }  
      console.log("hello there");
      console.log(data);
      })
  }

}