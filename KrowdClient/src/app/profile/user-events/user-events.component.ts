import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../../data-service.service'
import { AuthService } from '../../landing/auth/auth.service';

@Component({
  selector: 'app-user-events',
  templateUrl: './user-events.component.html',
  styleUrls: ['./user-events.component.css']
})
export class UserEventsComponent implements OnInit {

  userId: number;

  constructor(private dataService: DataServiceService, private authService: AuthService) { }

  ngOnInit() {
    this.getEventsByUserId();
    console.log(this.eventList);
  }

  eventList = [];
  getEventsByUserId() {
    this.userId =this.authService.getCurrentUser();
    console.log(this.userId);
    this.dataService.getEventsByUserId(this.userId)
      .subscribe(
        (events)=> {
          for (let event of events) {
            console.log(event)
            this.eventList.push(event)
          }
        },
        (error) => console.log(error)
      );
  }

}
