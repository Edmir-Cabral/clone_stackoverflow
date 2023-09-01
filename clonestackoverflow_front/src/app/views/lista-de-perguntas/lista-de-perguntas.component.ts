import { Component, OnInit } from '@angular/core';
import { Pergunta } from 'src/app/models/pergunta.model';
import { Resposta } from 'src/app/models/resposta.model';
import { PerguntaService } from '../../services/pergunta.service';
import { RespostaService } from '../../services/resposta.service';

@Component({
  selector: 'app-lista-de-perguntas',
  templateUrl: './lista-de-perguntas.component.html',
  styleUrls: ['./lista-de-perguntas.component.css'],
})
export class ListaDePerguntasComponent implements OnInit {
  constructor(
    private perguntaService: PerguntaService,
    private respostaService: RespostaService
  ) {
    this.perguntaService.read().subscribe((res) => {
      this.perguntas = res;
    });
    this.respostaService.read().subscribe((res) => {
      this.respostas = res;
    });
  }

  perguntas: Pergunta[] = [];
  respostas: Resposta[] = [];

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
