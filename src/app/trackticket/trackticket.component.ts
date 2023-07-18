import { Component, OnInit } from '@angular/core';
import { SupportticketserviceService } from '../supportticketservice.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Supportticket } from '../supportticket';

@Component({
  selector: 'app-trackticket',
  templateUrl: './trackticket.component.html',
  styleUrls: ['./trackticket.component.css']
})
export class TrackticketComponent implements OnInit{
  constructor(private formBuilder: FormBuilder,private supportticket:SupportticketserviceService){

  }
  
  ticketdetail!:Supportticket;
  myForm!: FormGroup;

  ngOnInit(): void {
    
    this.myForm = this.formBuilder.group({
      ticketId: [null] 
    });
  }
  getStatus(){
    const ticketIdValue = this.myForm.get('ticketId')?.value;
    
    this.supportticket.getSupportTicketBYID(ticketIdValue).subscribe((response)=>{
      
      this.ticketdetail=response;
      
      
      
      
    })
  }

}
// 236916984