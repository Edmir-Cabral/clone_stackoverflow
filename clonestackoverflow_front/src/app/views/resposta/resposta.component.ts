import { Pergunta } from './../../models/pergunta.model';
import { RespostaService } from './../../services/resposta.service';
import { AuthService } from 'src/app/services/auth.service';
import { Component, Inject, Injectable, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { inject } from '@angular/core';

import { Resposta } from 'src/app/models/resposta.model';
import { PerguntaService } from '../../services/pergunta.service';
import { ActivatedRoute, ParamMap, Params } from '@angular/router';
import { Observable, Subscription, map } from 'rxjs';

export interface EnviarResposta {
  descricao_resposta: string;
  data_resposta: number;
  usuario: {
    idGoogle: string;
  };
  pergunta: {
    id: number;
  };
}

@Component({
  selector: 'app-resposta',
  templateUrl: './resposta.component.html',
  styleUrls: ['./resposta.component.css'],
})
export class RespostaComponent implements OnInit {

  @Input() perguntaEdmir: number = 0;

  perguntas: Pergunta[] | any ;
  perguntaId: number = 0;
  descricao_resposta: string | any = '';
  idGoogle?: string | null = '';
  testeId: string | number = '';
  respostas: Resposta[] | any;
  armazenarId: string | number;
  perguntaIdString: string = '';


  constructor(
    private perguntaService: PerguntaService,
    private ActivatedRoute: ActivatedRoute,
    private authService: AuthService,
    private respostaService: RespostaService
  ) {

  }

  ngOnInit(): void {
    this.listagemInicialDeRespostas();
    this.perguntas = this.respostaService.read();
    this.perguntaService
      .buscarPorId(this.perguntaId)
     .subscribe((resp) => (console.log('FILIPE ',this.perguntas = resp)));
  }

  listagemInicialDeRespostas() {
    let params: Observable<Params> = this.ActivatedRoute.params;
    params.subscribe((urlParams) => {
      this.perguntaId = +urlParams['id'];

      console.log(this.perguntaId);


      this.respostaService.readById(this.perguntaId).subscribe(( res ) => {console.log('RESPOSTA', res.pergunta)});


      this.perguntaService.buscarPorId(this.perguntaId).subscribe(( res ) => {console.log('PERGUNTA',res.id)});

      console.log('PERGUNTA ID=', this.perguntaId);
    });
  }

  resposta: EnviarResposta = {
    descricao_resposta: this.descricao_resposta,
    data_resposta: Date.now(),
    usuario: {
      idGoogle: this.authService.extrairNomeIdGoogleDoUsuario(),
    },
    pergunta: {
      id:  this.perguntaEdmir
    },
  };


  enviarResposta(form: NgForm) {
    console.log(this.perguntaEdmir);

    console.log(this.resposta);

    this.respostaService.postResposta(this.resposta).subscribe((response) => {
      console.log(response);
    });
    form.reset();
  }
}
