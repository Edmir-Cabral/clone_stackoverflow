import { Component, OnInit } from '@angular/core';
import { Pergunta } from 'src/app/models/pergunta.model';
import { SharedService } from 'src/app/services/shared.service';
import { PerguntaService } from '../../services/pergunta.service';

@Component({
  selector: 'app-lista-de-perguntas',
  templateUrl: './lista-de-perguntas.component.html',
  styleUrls: ['./lista-de-perguntas.component.css'],
})
export class ListaDePerguntasComponent implements OnInit {
  perguntas: Pergunta[] = [];
  mostrarComRespostas = false;

  constructor(
    private perguntaService: PerguntaService,
    private sharedService: SharedService
  ) {}

  ngOnInit() {
    this.sharedService.resultadoDaBusca.subscribe((resultados: Pergunta[]) => {
      this.perguntas = resultados;
    });

    this.buscarTodasPerguntas();
  }

  buscarTodasPerguntas() {
    this.perguntaService.buscarTodas().subscribe((resultados) => {
      this.perguntas = resultados;
    });

    this.animacaoDosFiltros('botaoEsquerdo');
  }

  buscarRespondidas() {
    this.perguntaService.buscarTodas().subscribe((resultados) => {
      this.perguntas = [];
      for (let resultado of resultados) {
        if (resultado.respostas?.length != 0) {
          this.perguntas.push(resultado);
        }
      }
    });

    this.animacaoDosFiltros('botaoCentro');
  }

  buscarNaoRespondidas() {
    this.perguntaService.buscarTodas().subscribe((resultados) => {
      this.perguntas = [];
      for (let resultado of resultados) {
        if (resultado.respostas?.length == 0) {
          this.perguntas.push(resultado);
        }
      }
    });

    this.animacaoDosFiltros('botaoDireito');
  }

  animacaoDosFiltros(nomeBotao: string) {
    document.querySelector(`.${nomeBotao}`)?.classList.add('selecionado');

    switch (nomeBotao) {
      case 'botaoEsquerdo': {
        document.querySelector('.botaoCentro')?.classList.remove('selecionado');
        document
          .querySelector('.botaoDireito')
          ?.classList.remove('selecionado');
        break;
      }

      case 'botaoCentro': {
        document
          .querySelector('.botaoEsquerdo')
          ?.classList.remove('selecionado');
        document
          .querySelector('.botaoDireito')
          ?.classList.remove('selecionado');
        break;
      }

      case 'botaoDireito': {
        document
          .querySelector('.botaoEsquerdo')
          ?.classList.remove('selecionado');
        document.querySelector('.botaoCentro')?.classList.remove('selecionado');
        break;
      }
    }
  }
}
