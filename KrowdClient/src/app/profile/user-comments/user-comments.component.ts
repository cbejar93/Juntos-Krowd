import { Component, OnInit } from '@angular/core';
import { DataServiceService } from 'src/app/data-service.service';

@Component({
  selector: 'app-user-comments',
  templateUrl: './user-comments.component.html',
  styleUrls: ['./user-comments.component.css']
})
export class UserCommentsComponent implements OnInit {

  constructor(private dataService: DataServiceService) { }

  ngOnInit() {
    this.getCommentsByUserId();
  }

  getCommentsByUserId() {
    var userId = 16;
    this.dataService.getCommentsByUserId(userId) 
        .subscribe(
          (response) => console.log(response),
          (error) => console.log(error)
        );
  }

}
