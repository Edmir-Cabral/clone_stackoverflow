import { Component, OnDestroy, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Pergunta } from 'src/app/models/pergunta.model';
import { Resposta } from 'src/app/models/resposta.model';
import { PerguntaService } from 'src/app/services/pergunta.service';

@Component({
  selector: 'app-pergunta',
  templateUrl: './pergunta.component.html',
  styleUrls: ['./pergunta.component.css']
})
export class PerguntaComponent implements OnInit, OnDestroy {

  perguntaId: number | undefined;
  pergunta: Pergunta | undefined;
  respostas: Resposta [] = [];
  isLoading = true;
  private subscription: Subscription | undefined;

  constructor(private route: ActivatedRoute, private perguntaService: PerguntaService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam !== null) {
        this.perguntaId = +idParam;
        // Agora você pode usar this.perguntaId para buscar os detalhes da pergunta com o ID correspondente
        this.subscription = this.perguntaService.readById(this.perguntaId).subscribe({
          next: (pergunta: Pergunta) => {
            this.pergunta = pergunta;
            this.isLoading = false;
            console.log(pergunta.respostas);
            console.log(pergunta);
          },
          error: error => {
            console.error(error);
            this.isLoading = false;
          }
        });
      }
    });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
