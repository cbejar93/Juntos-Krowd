import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Event } from './home/event.model';
import { UserModelService } from './user-model.service';
import 'rxjs/Rx'; 
import { Observable } from 'rxjs/Observable'; 
import { catchError } from 'rxjs/operators'; 
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private httpClient: HttpClient) { }

  getAllEvents(){
    return this.httpClient.get<Event []>("http://localhost:8080/Krowd/event/all")
      .map((events)=>{
        let eventData = events;
        return eventData;

      })
      .pipe(catchError(error=>{
        return throwError(error);
      }))
  }

  getEventbyId(id:number){
        return this.httpClient.get<Event>(`http://localhost:8080/Krowd/events/${id}`)
          .map((event)=>
          {return event;}
              
          )
          .pipe(catchError(error=>{
            return throwError(error);
          }))
  }

  getAllUsers (){

   return this.httpClient.get<UserModelService []>("http://localhost:8080/Krowd/users/all")
      .map(
          (users)=>{
            let usersData = users;
            return usersData; 

      })
      .pipe(catchError(error=>{
        return throwError(error);
      }))
  }

  //everything below here needs to be modified

  createNewEvent (event: Event) {
    return this.httpClient.post("http://localhost:8080/Krowd/event/add", event);
  }

  editUserInfo(userId: number) {
    return this.httpClient.put("http://localhost:8080/Krowd/users/all", userId)
  }

  getEventsByUserId(userId: number) {
    return this.httpClient.get<Event []>(`http://localhost:8080/Krowd/events/${userId}`)
          .map((events)=>{
            let eventData = events;
            return eventData;
          })
          .pipe(catchError(error=>{
            return throwError(error);
          }))
  }

  getCommentsByUserId(userId: number) {
    return this.httpClient.get<Comment []>(`http://localhost:8080/Krowd/comment/user/${userId}`)
          .map((comments)=>{
            let commentData = comments;
            return commentData;
          })
          .pipe(catchError(error=>{
            return throwError(error);
          }))
  }
}
