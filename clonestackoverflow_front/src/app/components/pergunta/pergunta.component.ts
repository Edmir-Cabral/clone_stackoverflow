
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
  constructor(private perguntaService: PerguntaService) {
    this.perguntaService.read().subscribe(res => { this.perguntas = res })   
  }
  perguntas: Pergunta[] = [];
  respostas: Resposta[] = [];
  padrao!: String;
  titulo: any [] = [];
  buscarTitulo!: String;
  test = "test";
  ngOnInit(): void {

  };

  buscaPergunta(): void{
    this.perguntaService.buscaPorTitulo(this.test).subscribe(res => {
      console.log(res);
    })
  }

  getPerguntas(): void {
    this.perguntaService.read().subscribe(res => { this.perguntas = res, console.log(res);
    })
  }


  getRespondidas(): void{

  }

  getNaoRespondidas(): void{
    
  }
}
