import { Component } from '@angular/core';

import { Pergunta } from '../../models/pergunta.model'

@Component({
  selector: 'app-resposta',
  templateUrl: './resposta.component.html',
  styleUrls: ['./resposta.component.css']
})
export class RespostaComponent {

  pergunta: Pergunta | any;
}
