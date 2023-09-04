import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedDataService {

  sharedValue: string ='';
  constructor() { }
}
