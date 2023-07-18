import { Component, OnInit } from '@angular/core';
import { SupportticketserviceService } from '../supportticketservice.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Createticket } from '../createticket';

@Component({
  selector: 'app-createticket',
  templateUrl: './createticket.component.html',
  styleUrls: ['./createticket.component.css']
})
export class CreateticketComponent implements OnInit{
  ngOnInit(): void {
    
  }
  createTicket = new FormGroup({
    assetID: new FormControl(null),
    ticketRaisedByEmployee: new FormControl(''),
  });

  constructor(private supportticket:SupportticketserviceService){

  }

  createtkt(){
    const createtkt:Createticket={
      assetID:this.createTicket.value.assetID||0,
      ticketRaisedByEmployee:this.createTicket.value.ticketRaisedByEmployee||''
    }
    this.supportticket.postTicket(createtkt).subscribe((data)=>{

    })

  }

}
