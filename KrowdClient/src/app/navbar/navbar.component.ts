import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { AuthService } from '../landing/auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  nameOfClick: string='home';
  isActiveClass: boolean = false

  getID(event: any){
    // console.log(event.srcElement.id);
    this.nameOfClick = event.srcElement.id
    console.log(this.nameOfClick);
    if (this.nameOfClick ==='home'){

    }
  }

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
  }


  onLogout(){
    console.log("hellot");
    this.router.navigate(['/landing']);
    this.authService.logOut();
  }
}
