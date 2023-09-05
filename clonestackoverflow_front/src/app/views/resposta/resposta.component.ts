import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { RespostaService } from './../../services/resposta.service';

import { ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { Resposta } from 'src/app/models/resposta.model';
import { PerguntaService } from '../../services/pergunta.service';

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
  resposta_enviada: EnviarResposta;
  respostas: Resposta[];
  perguntaId: number = 0;
  descricao_resposta: string | any = '';
  idGoogle?: string | null = '';

  constructor(
    private perguntaService: PerguntaService,
    private ActivatedRoute: ActivatedRoute,
    private authService: AuthService,
    private respostaService: RespostaService
  ) {}

  ngOnInit(): void {
    let params: Observable<Params> = this.ActivatedRoute.params;
    params.subscribe((urlParams) => {
      this.perguntaId = +urlParams['id'];
    });

    this.listagemInicialDeRespostas();
  }

  listagemInicialDeRespostas() {
    this.perguntaService
      .buscarPorId(this.perguntaId)
      .subscribe((resp) => (this.respostas = resp.respostas));
  }

  resposta: EnviarResposta = {
    descricao_resposta: this.descricao_resposta,
    data_resposta: Date.now(),
    usuario: {
      idGoogle: this.authService.extrairNomeIdGoogleDoUsuario(),
    },
    pergunta: {
      id: this.perguntaId,
    },
  };

  enviarResposta(form: NgForm) {
    this.resposta_enviada = {
      descricao_resposta: this.resposta.descricao_resposta,
      data_resposta: Date.now(),
      usuario: {
        idGoogle: this.authService.extrairNomeIdGoogleDoUsuario(),
      },
      pergunta: {
        id: this.perguntaId,
      },
    };

    this.respostaService
      .postResposta(this.resposta_enviada)
      .subscribe(() => {});

    form.reset();
    location.reload();
  }
}
