import { SharedDataService } from './../../../services/shared-data.service';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  /*
  valorDigitado: String = ''
  capturaValor(){
    console.log("valor digitado:", this.valorDigitado);
  }*/
  inputValue: string = '';

  constructor(private sharedDataService: SharedDataService){}
  
  shareValue(event: any){
    const value = event.target.value;
    this.sharedDataService.sharedValue = value;
    console.log(value);
  }
}
