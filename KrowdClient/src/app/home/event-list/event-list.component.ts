import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataServiceService } from 'src/app/data-service.service';
import { analyzeAndValidateNgModules } from '@angular/compiler';

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

  eventList2 = [];
  getAllEvents() {
      console.log(this.dataService.getAllEvents());
      this.dataService.getAllEvents()
        .subscribe(
          (events)=> {
            for (let event of events) {
              console.log(event)
              this.eventList2.push(event)
              if (event.photo_url===null){
                event.photo_url= "http://saveabandonedbabies.org/wp-content/uploads/2015/08/default.png";
                }
              }
            },
          (error)=> console.log(error)
          );


        console.log(this.eventList2);
        return this.eventList2;
  }



}
