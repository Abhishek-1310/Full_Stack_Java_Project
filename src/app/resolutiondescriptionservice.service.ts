import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Resolutiondescription } from './resolutiondescription';
import { Observable } from 'rxjs/internal/Observable';
import { Resolution } from './resolution';
import { UpdateResponse } from './resolveticket/update-response';

@Injectable({
  providedIn: 'root'
})

export class ResolutiondescriptionserviceService {
  constructor(private http: HttpClient) {}
  private baseUrl: string =
    'http://localhost:8080/api/supportrequests/open/api/supportrequests';

  resolvedescription(
    asset: Resolutiondescription,
    id: number
  ): Observable<UpdateResponse> {
    

    console.log(asset);
    console.log(id);
    console.log('hello');
    const url = `${this.baseUrl}/${id}/resolve`;
   
    let resolutionDescription = asset;
    let desc = { resolutionDescription };
    return this.http.put<UpdateResponse>(url, desc);
  }
}





