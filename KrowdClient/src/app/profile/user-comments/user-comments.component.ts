import { Component, OnInit } from '@angular/core';
import { DataServiceService } from 'src/app/data-service.service';
import { AuthService } from '../../landing/auth/auth.service';

@Component({
  selector: 'app-user-comments',
  templateUrl: './user-comments.component.html',
  styleUrls: ['./user-comments.component.css']
})
export class UserCommentsComponent implements OnInit {
  userId: number;
  eventID: number
  constructor(private dataService: DataServiceService, private authService: AuthService) { }

  ngOnInit() {
    
    this.getCommentsByUserId();
  }

  commentsList = [];
  getCommentsByUserId() {
    this.userId =this.authService.getCurrentUser();
    this.dataService.getCommentsByUserId(this.userId) 
        .subscribe(
          (comments)=> {
            for (let comment of comments) {
              console.log(comment)
              let eid=comment['event_id']
              this.dataService.getEventbyId(eid).subscribe(res=> 
                { console.log(res);
                  comment['event_id'] = res['event_name'];
                  this.eventID = res['event_id'];
                }
                )
              this.commentsList.push(comment)
              }
            },
          (error)=> console.log(error)
          );  
          
        console.log(this.commentsList);
        return this.commentsList;
  }

}
