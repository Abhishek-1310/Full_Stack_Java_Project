import { Component, OnInit } from '@angular/core';
import { SupportticketserviceService } from '../supportticketservice.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Supportticket } from '../supportticket';
import { ActivatedRoute } from '@angular/router';
import { ResolutiondescriptionserviceService } from '../resolutiondescriptionservice.service';
import { Resolutiondescription } from '../resolutiondescription';

@Component({
  selector: 'app-resolveticket',
  templateUrl: './resolveticket.component.html',
  styleUrls: ['./resolveticket.component.css']
})
export class ResolveticketComponent implements OnInit{
  constructor(private formBuilder: FormBuilder,private supportticketservice:SupportticketserviceService, private resolutiondescription:ResolutiondescriptionserviceService,private route:ActivatedRoute){}

  id!:number;
  myForms!: FormGroup;
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.onResolvedTkt(this.id);
    this.myForms = this.formBuilder.group({
      resolutionDescriptions: [''] 
    });
    
  }

  ticketdetail!: Supportticket;

  resolveticket(){
    const resolutiondesc = this.myForms.get('resolutionDescriptions')?.value;
    console.log(resolutiondesc);
   
    this.resolutiondescription.resolvedescription(resolutiondesc,this.id).subscribe((result)=>{
      console.log(result);
    })
  }

  onResolvedTkt(id:number){
    this.supportticketservice.getSupportTicketBYID(id).subscribe((response)=>{
      this.ticketdetail=response;
      console.log(this.ticketdetail);
    })

  }


}
//i have changed the ram now everything working fine
// motherborad is not working, so i have changed it, now it working fine