import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../../data-service.service'

@Component({
  selector: 'app-user-events',
  templateUrl: './user-events.component.html',
  styleUrls: ['./user-events.component.css']
})
export class UserEventsComponent implements OnInit {

  constructor(private dataService: DataServiceService) { }

  ngOnInit() {
    this.getEventsByUserId();
  }

  eventList = [];
  getEventsByUserId() {
    var userId = 16;
    this.dataService.getEventsByUserId(userId)
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
