import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Event } from '../home/event.model';
import { HttpClient } from '@angular/common/http';
import { CloudinaryOptions, CloudinaryUploader } from 'ng2-cloudinary';

@Component({
  selector: 'app-event-creator',
  templateUrl: './event-creator.component.html',
  styleUrls: ['./event-creator.component.css']
})
export class EventCreatorComponent implements OnInit {
  submitted = false;
  @Output() eventCreated = new EventEmitter<{eventName:string}>();
  newEventName:string;

  ngOnInit() {
  }

  onEventCreated(form: NgForm){
    //code for adding the new event to the database
    console.log('Event Successfully Created');
    console.log(form);
    const value = form.value;
    console.log(form.value)
    const newEvent = new Event(null, value.eventName, 
      value.eventLocation, value.eventDescription, 
      value.eventCategory, value.eventDate, 
      null, this.imageURL, 
      null, value.eventPeople);
    this.eventCreated.emit({eventName: this.newEventName});
    console.log(newEvent);
    this.submitted = true;
  }

//code for image upload
  selectedFile: File = null;
  imageURL: string;
  picture: string = "http://saveabandonedbabies.org/wp-content/uploads/2015/08/default.png";
  constructor(http: HttpClient) { }

  uploader: CloudinaryUploader = new CloudinaryUploader(
    new CloudinaryOptions({ cloudName: 'dhazivqjc', uploadPreset: 'zalhcbr6' })
    );

    loading: any;
    upload(){
      this.loading = true;
      this.uploader.uploadAll();
      this.uploader.onSuccessItem = (item: any, response: string, status: number, headers: any): any => {
           let res: any = JSON.parse(response);
           console.log(res);
           this.imageURL=res.url;
           console.log(this.imageURL);
           this.picture=this.imageURL;
       }
       this.uploader.onErrorItem = function(fileItem, response, status, headers) {
          console.info('onErrorItem', fileItem, response, status, headers);
        };
        console.log("picture upload successful")
    }

}
