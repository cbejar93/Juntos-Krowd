import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataServiceService } from '../data-service.service'

@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  event : {id: number, photo: string, name: string, description: string, location:string, date: any, user_id:number}
  
  constructor(private route: ActivatedRoute, private dataService: DataServiceService) { }

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
    // this.eventID = ;

    this.dataService.getEventbyId(this.event.id)
      .subscribe(
        (data) => this.event = {
          id: data.event_id,
          photo: data.photo_url,
          name: data.event_name,
          description: data.event_description,
          location: data.event_location,
          date: data.event_date,
          user_id: data.user_id
        }
      )
  }

}
