import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './landing/landing.component';
import { ServersComponent } from './servers/servers.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { EventListComponent } from './home/event-list/event-list.component';
import { ProfileComponent } from './profile/profile.component';
import { EventCreatorComponent } from './event-creator/event-creator.component';
import { ImageUploadComponent } from './image-upload/image-upload.component';
import { HttpClientModule } from '@angular/common/http';
import { Ng2CloudinaryModule } from 'ng2-cloudinary';
import { FileUploadModule } from 'ng2-file-upload';
import { Routes, RouterModule } from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EditEventComponent } from './home/edit-event/edit-event.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UserCommentsComponent } from './profile/user-comments/user-comments.component';
import { EditProfileComponent } from './profile/edit-profile/edit-profile.component';
import { UserEventsComponent } from './profile/user-events/user-events.component';
import { DataServiceService } from './data-service.service';
import { SigninComponent } from './landing/auth/signin/signin.component';
import { SignupComponent } from './landing/auth/signup/signup.component';
import { AuthGuardService } from './landing/auth/auth-guard.service';
import { AuthService } from './landing/auth/auth.service';
import { UserModelService } from './user-model.service';
import { EventPageComponent } from './event-page/event-page.component';



const appRoutes: Routes = [
  { path:'home', component: HomeComponent },
  { path:'profile', component: ProfileComponent, 
  
    children:[
    {path: 'comments', component: UserCommentsComponent},
    {path: 'events', component: UserEventsComponent},
    {path: 'edit', component: EditProfileComponent}
  ]
  },
  {path: 'create', component: EventCreatorComponent},
  {path: 'landing', component: LandingComponent
  ,
  children:[
    {path: 'signup', component: SignupComponent},
    {path: 'signin', component: SigninComponent}
  ]
  
  },
  {path:'event/:id/:photo/:name/:description/:location/:date/:user_id', component: EventPageComponent},
  {path: 'not-found', component: PageNotFoundComponent},
  {path: '**', redirectTo: '/not-found'}

]

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    ServersComponent,
    NavbarComponent,
    HomeComponent,
    EventListComponent,
    ProfileComponent,
    EventCreatorComponent,
    ImageUploadComponent,
    EditEventComponent,
    PageNotFoundComponent,
    UserCommentsComponent,
    EditProfileComponent,
    UserEventsComponent,
    SigninComponent,
    SignupComponent,
    EventPageComponent
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2CloudinaryModule,
    FileUploadModule,
    RouterModule.forRoot(appRoutes),
    NgbModule

  ],
  providers: [DataServiceService, AuthService,UserModelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
