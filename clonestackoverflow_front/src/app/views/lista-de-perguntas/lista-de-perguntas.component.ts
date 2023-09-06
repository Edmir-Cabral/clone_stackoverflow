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
  
  constructor(private perguntaService: PerguntaService, private sharedService: SharedService) { }
  
  ngOnInit() {
    this.sharedService.resultadoDaBusca.subscribe((resultados: Pergunta[]) => {
      this.perguntas = resultados;
    });
    this.buscarTodasPerguntas();
  }
  
  buscarTodasPerguntas() {
    this.perguntaService.buscarTodas().subscribe((resultados) => {
      this.perguntas = resultados;
    })
  }

  buscarRespondidas() {
    this.perguntaService.buscarTodas().subscribe((resultados) => {
      this.perguntas = []
      for (let resultado of resultados) {
        if (resultado.respostas?.length != 0) {
          this.perguntas.push(resultado)
        }
      }
    })
  }

  buscarNaoRespondidas(){
    this.perguntaService.buscarTodas().subscribe((resultados) => {
      this.perguntas = []
      for (let resultado of resultados) {
        if (resultado.respostas?.length == 0) {
          this.perguntas.push(resultado)
        }
      }
    })
  }
}
