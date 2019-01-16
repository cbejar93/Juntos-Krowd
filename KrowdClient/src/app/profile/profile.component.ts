import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user : {id: number, photo: string, firstname: string, lastname: string, tokenscore: number}

  constructor(private router: Router, private dataService: DataServiceService) { }

  ngOnInit() {
    this.getUserInfo();
  }

  getUserInfo() {
    this.dataService.getAllUsers()
      .subscribe(
        (users) => {
        for (let user of users) {
          if (user.userid == 626) {
            this.user = {
              id: user.userid,
              photo: user.photo_url,
              firstname: user.firstname,
              lastname: user.lastname,
              tokenscore: user.token_score
            }
            console.log(user)
            return user
            }
          }
        },
      (error)=> console.log(error)
      );
  }

}
