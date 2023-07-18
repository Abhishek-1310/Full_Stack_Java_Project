import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Registerasset } from './registerasset';

@Injectable({
  providedIn: 'root'
})
export class AssetregisterService {

  constructor(private http:HttpClient) { }
  private baseUrl:string='http://localhost:8080/api/asset';

  registerAsset(asset:Registerasset):Observable<Registerasset>{
      return this.http.post<Registerasset>(this.baseUrl+'/register',asset);
  }
}
