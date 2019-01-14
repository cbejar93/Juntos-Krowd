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

  getEventsByUserId() {
    var userId = 2;
    this.dataService.getEventsByUserId(userId)
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      );
  }

}
