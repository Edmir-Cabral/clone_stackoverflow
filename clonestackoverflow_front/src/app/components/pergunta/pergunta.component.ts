
import { RespostaService } from './../../services/resposta.service';
import { PerguntaService } from './../../services/pergunta.service';
import { Component, OnInit } from '@angular/core';
import { Pergunta } from 'src/app/models/pergunta.model';
import { Resposta } from 'src/app/models/resposta.model';



@Component({
  selector: 'app-pergunta',
  templateUrl: './pergunta.component.html',
  styleUrls: ['./pergunta.component.css'],
})

export class PerguntaComponent implements OnInit {
  constructor(private perguntaService: PerguntaService, private respostaService: RespostaService) {
    this.perguntaService.read().subscribe(res => { this.perguntas = res })
    this.respostaService.read().subscribe(res => { this.respostas = res })
  }
  perguntas: Pergunta[] = [];
  respostas: Resposta[] = [];

  ngOnInit(): void {

  };

  getPerguntas(): void {
    this.perguntaService.read().subscribe(res => { this.perguntas = res, console.log(res);
    })
  }

  buscaPergunta(): void{
    
  }

  getRespondidas(): void{

  }

  getNaoRespondidas(): void{
    
  }
}
