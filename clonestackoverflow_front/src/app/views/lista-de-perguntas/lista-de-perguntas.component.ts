import { SharedDataService } from './../../services/shared-data.service';
import { Component, Input, OnInit } from '@angular/core';
import { Pergunta } from 'src/app/models/pergunta.model';
import { PerguntaService } from '../../services/pergunta.service';

@Component({
  selector: 'app-lista-de-perguntas',
  templateUrl: './lista-de-perguntas.component.html',
  styleUrls: ['./lista-de-perguntas.component.css'],
})
export class ListaDePerguntasComponent implements OnInit {

  constructor(private perguntaService: PerguntaService, public SharedDataService: SharedDataService) {
    this.perguntaService.read().subscribe((res) => {
      this.perguntas = res;
    });   
  }

  perguntas: Pergunta[] = [];

  ngOnInit(): void {}

  getPerguntas(): void {
    this.perguntaService.read().subscribe((res) => {
      (this.perguntas = res), console.log(res);
    });
  }

  buscaPergunta(): void {}

  getRespondidas(): void {}

  getNaoRespondidas(): void {}

}
