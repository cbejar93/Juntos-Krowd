import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserModelService } from 'src/app/user-model.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private user: UserModelService, private router: Router) { }

  signUpUser(username: string, password: string){
      this.http.post("what is the url shit", {username, password}).subscribe((event)=> console.log(event))

  }

  signInUser(username: string, password: string){

      this.http.post("some url shit i dont know yet", {username, password})
      
        .subscribe((event)=> 
        this.router.navigate(["/home"]))
        
  }

  isAuthenticated(){
    return this.user != null
  }

  logOut(){

  }
}
