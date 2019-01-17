import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Event } from './home/event.model';
import { UserModelService } from './user-model.service';
import 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { AuthService } from './landing/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  httpHeaders = new HttpHeaders ({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
  });

  constructor(private httpClient: HttpClient, private authService: AuthService) { }

  getAllEvents() {
    return this.httpClient.get<Event[]>("http://localhost:8080/Krowd/event/all")
      .map((events) => {
        let eventData = events;
        return eventData;
      })
      .pipe(catchError(error => {
        return throwError(error);
      }))
  }

  getEventbyId(id: number) {
    return this.httpClient.get<Event>(`http://localhost:8080/Krowd/event/${id}`)
      .map((event) => { return event; }

      )
      .pipe(catchError(error => {
        return throwError(error);
      }))
  }

  getAllUsers() {

    return this.httpClient.get<UserModelService[]>("http://localhost:8080/Krowd/user/all")
      .map(
        (users) => {
          let usersData = users;
          return usersData;

        })
      .pipe(catchError(error => {
        return throwError(error);
      }))
  }

  createNewEvent (event: Event) {

    console.log("new event sent to the database");
    console.log(event);
    return this.httpClient.post("http://localhost:8080/Krowd/event/add", event, 
    {
      headers: this.httpHeaders,
    }
    )
      .subscribe((res)=>
        console.log(res)
      )
  }

  getUserById(userID: number){
    return this.httpClient.get(`http://localhost:8080/Krowd/user/${userID}`)
  }

  getCommentsByUserId(userId: number) {
    return this.httpClient.get<Comment[]>(`http://localhost:8080/Krowd/comment/user/${userId}`)
      .map((comments) => {
        let commentData = comments;
        return commentData;
      })
      .pipe(catchError(error => {
        return throwError(error);
      }))
  }

  //everything below here needs to be modified

  editUserInfo(user: string) {
    return this.httpClient.put("http://localhost:8080/Krowd/user/update", user)
  }

  getEventsByUserId(userId: number) {

    return this.httpClient.get<Event[]>(`http://localhost:8080/Krowd/event/user/${userId}`)
      .map((events) => {
        let eventData = events;
        return eventData;
      })
      .pipe(catchError(error => {
        return throwError(error);
      }))
  }

  registerForEvent(eventId: number, userId: number) {
    return this.httpClient.post("", eventId)
  }

  getCommentsByEventId(eventId: number) {
    return this.httpClient.get<Comment[]>(`http://localhost:8080/Krowd/comment/event/${eventId}`)
      .map((comments) => {
        let commentData = comments;
        return commentData;
      })
      .pipe(catchError(error => {
        return throwError(error);
      }))
  }

  getUserByFID(fID: string){
    
  }

  addComment(data: string, event: any, userId: number) {
    console.log(event);
    this.httpClient.post('http://localhost:8080/Krowd/comment/add', { 'data':data,'event': event, 'Created': null,'user_id': userId })
      .subscribe((comment) => console.log(comment));
  }
}

  
