import { Component, OnInit } from '@angular/core';
import {DataServiceService} from '../data-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  events: [];
  constructor(private dataService: DataServiceService) { }

  ngOnInit() {
    
  }

  onGetUser(){
    console.log("hello there")
    this.dataService.getAllUsers()
      .subscribe(
        (response)=> console.log(response),
        (error)=> console.log(error)
        );
        
  }

  onEventAdded(eventData:{eventName:string}){
    console.log(eventData.eventName);
  }

}
