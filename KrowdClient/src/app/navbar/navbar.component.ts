import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

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
      console.log(this.nameOfClick);
    }
  }

  constructor(private router: Router) { }

  ngOnInit() {
  }
  onLogout(){
    console.log("hellot");
    this.router.navigate(['/landing']);
  }
}
