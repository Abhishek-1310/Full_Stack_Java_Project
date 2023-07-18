import { Component, OnInit } from '@angular/core';
import { AssetregisterService } from '../assetregister.service';
import {FormGroup,FormControl} from '@angular/forms';
import { Registerasset } from '../registerasset';

@Component({
  selector: 'app-registerasset',
  templateUrl: './registerasset.component.html',
  styleUrls: ['./registerasset.component.css']
})
export class RegisterassetComponent implements OnInit{

  

  constructor(private assetregister:AssetregisterService){}
  ngOnInit(): void {
    
  }
  registerAsset = new FormGroup({
    assetID: new FormControl(null),
    issuedOn: new FormControl(''),
    issuedToEmployee: new FormControl(''),
    modelNo: new FormControl(''),
    make: new FormControl(''),
    assetType: new FormControl('')
  });
 

  registerAssets(){
    const issuedOnValue = this.registerAsset.value.issuedOn;
    const registerass: Registerasset = {
      assetID: this.registerAsset.value.assetID || 0,
      issuedOn: issuedOnValue ? new Date(issuedOnValue) : new Date(),
      issuedToEmployee: this.registerAsset.value.issuedToEmployee || '',
      modelNo: this.registerAsset.value.modelNo || '',
      make: this.registerAsset.value.make || '',
      assetType: this.registerAsset.value.assetType || ''
    };

    this.assetregister.registerAsset(registerass).subscribe((data) => {
      
    });

    console.log(this.registerAsset.value);
  }
}
