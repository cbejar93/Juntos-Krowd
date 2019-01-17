import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataServiceService } from '../data-service.service'
import { AuthService } from '../landing/auth/auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  event : {id: number, photo: string, name: string, description: string, location:string, date: any, user_id:number}
  
  constructor(private route: ActivatedRoute, private dataService: DataServiceService, private authService: AuthService) { }
  userID: number;
  toggle: boolean = false;
  commentUserID: number;
  usercomment: {
    username: string,
    picture: string,
    comment: any
  }

  attendingList = [];

  newComment : {data: string, eventId: number, userId: number}

  commentsList = [];
  ngOnInit() {
    this.event ={
      id: this.route.snapshot.params['id'],
      photo: this.route.snapshot.params['photo'],
      name: this.route.snapshot.params['name'],
      description: this.route.snapshot.params['description'],
      location: this.route.snapshot.params['location'],
      date: this.route.snapshot.params['date'],
      user_id: this.route.snapshot.params['user_id']
    }
    console.log(this.event);
    this.userID= this.authService.getCurrentUser();
    // this.eventID = ;
    this.getEvent(this.event.id)

      this.dataService.getCommentsByEventId(this.event.id)
        .subscribe(
          (comments)=> {
            for (let comment of comments) {
              console.log(comment);
              this.commentUserID = comment['user_id'];
              console.log(this.commentUserID);
              this.dataService.getUserById(this.commentUserID)
              .subscribe((res)=> {
                console.log(res);
                this.usercomment = {
                  username: res['username'],
                  picture: res['photo_url'],
                  comment: comment
                }
                console.log("New user comment:");
                console.log(this.usercomment);
                this.commentsList.push(this.usercomment);

              }
              
              )
             
              }
            },
          (error)=> console.log(error)
          );
        console.log("Comments list: ")
        console.log(this.commentsList);
        return this.commentsList;
  }

  getEvent(eID){
    this.dataService.getEventbyId(eID)
      .subscribe(
        (data) =>{ this.event = {
          id: data.event_id,
          photo: data.photo_url,
          name: data.event_name,
          description: data.event_description,
          location: data.event_location,
          date: data.event_date,
          user_id: data.user_id
        }
          return this.event;
      }
      )
      }

  ontoggle() {
    if (this.toggle == true) {
    this.toggle = false;
      }
    else {
      this.toggle = true;
     } 
    }

  onCommentCreated(form: NgForm) {
    const value = form.value;
    console.log(this.event);
    //console.log(this.getEvent(this.event.id));
    this.dataService.addComment(value.data, this.event, this.userID)
    form.resetForm();
  }
}

