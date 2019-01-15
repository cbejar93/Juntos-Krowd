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

  commentsList = [];
  getCommentsByUserId() {
    var userId = 16;
    this.dataService.getCommentsByUserId(userId) 
        .subscribe(
          (comments)=> {
            for (let comment of comments) {
              console.log(comment)
              this.commentsList.push(comment)
              }
            },
          (error)=> console.log(error)
          );
          
        console.log(this.commentsList);
        return this.commentsList;
  }

}
