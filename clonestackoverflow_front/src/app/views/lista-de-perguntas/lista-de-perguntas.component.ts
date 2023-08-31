
import { RespostaService } from '../../services/resposta.service';
import { PerguntaService } from '../../services/pergunta.service';
import { Component, OnInit } from '@angular/core';
import { Pergunta } from 'src/app/models/pergunta.model';
import { Resposta } from 'src/app/models/resposta.model';

@Component({
  selector: 'app-lista-de-perguntas',
  templateUrl: './lista-de-perguntas.component.html',
  styleUrls: ['./lista-de-perguntas.component.css'],
})

export class ListaDePerguntasComponent implements OnInit {
  constructor(private perguntaService: PerguntaService, private respostaService: RespostaService) {
    this.perguntaService.read().subscribe(res => { this.perguntas = res })
    this.respostaService.read().subscribe(res => { this.respostas = res })
  }

  
  perguntas: Pergunta[] = [];
  respostas: Resposta[] = [];
  padrao!: String;
  titulo: any [] = [];
  buscarTitulo!: String;
  test = "test";
  ngOnInit(): void {

  };


  getPerguntas(): void {
    this.perguntaService.read().subscribe(res => { this.perguntas = res, console.log(res);
    })
  }


  getRespondidas(): void{

  }

  getNaoRespondidas(): void{
    
  }
}
