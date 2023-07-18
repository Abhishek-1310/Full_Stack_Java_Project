import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterassetComponent } from './registerasset/registerasset.component';
import { SupportticketlistComponent } from './supportticketlist/supportticketlist.component';
import { ResolveticketComponent } from './resolveticket/resolveticket.component';
import { TrackticketComponent } from './trackticket/trackticket.component';

import {HttpClientModule} from  '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CreateticketComponent } from './createticket/createticket.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { HomepageComponent } from './homepage/homepage.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterassetComponent,
    SupportticketlistComponent,
    ResolveticketComponent,
    TrackticketComponent,
    CreateticketComponent,
    PagenotfoundComponent,
    HomepageComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
