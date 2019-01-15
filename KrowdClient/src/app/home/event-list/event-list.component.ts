import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataServiceService } from 'src/app/data-service.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

 @Input() eventList= [];
  constructor(private httpClient: HttpClient, private dataService: DataServiceService) { }

  ngOnInit() {
    this.getAllEvents();
  }

  getAllEvents() {
      console.log(this.dataService.getAllEvents());
      this.dataService.getAllEvents()
        .subscribe(
          (response)=> console.log(response),
          (error)=> console.log(error)
          );

  }



}
