import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Supportticket } from './supportticket';
import { Observable } from 'rxjs/internal/Observable';
import { Createticket } from './createticket';

@Injectable({
  providedIn: 'root'
})
export class SupportticketserviceService {

  constructor(private http:HttpClient) { }
  private baseUrl:string='http://localhost:8080/api/supportrequests';

  getSupportTicket():Observable<Supportticket[]>{
    return this.http.get<Supportticket[]>(this.baseUrl+"/open");
  }
  getSupportTicketBYID(Id:number):Observable<Supportticket>{
    return this.http.get<Supportticket>(this.baseUrl+"/ticketId/"+Id);
  }
  
  postTicket(ticket:Createticket):Observable<Supportticket>{
    return this.http.post<Supportticket>(this.baseUrl+'/new',ticket);
  }
}
