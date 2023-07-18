import { Component, OnInit } from '@angular/core';
import { Supportticket } from '../supportticket';
import { SupportticketserviceService } from '../supportticketservice.service';

@Component({
  selector: 'app-supportticketlist',
  templateUrl: './supportticketlist.component.html',
  styleUrls: ['./supportticketlist.component.css']
})
export class SupportticketlistComponent implements OnInit{

  supportticket:Supportticket[]=[];
  constructor(private supportticketservice:SupportticketserviceService){}
  ngOnInit(): void {
    this.supportticketservice.getSupportTicket().subscribe((response)=>{
      this.supportticket=response;
      console.log(this.supportticket);
    })
  }

}
