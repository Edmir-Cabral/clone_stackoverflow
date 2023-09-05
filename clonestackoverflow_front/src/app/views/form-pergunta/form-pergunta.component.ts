import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { PerguntaService } from 'src/app/services/pergunta.service';

export interface CadastroPergunta {
  titulo_pergunta: string;
  descricao_pergunta: string;
  data_pergunta: number;
  usuario: {
    idGoogle: string;
  };
}

@Component({
  selector: 'app-form-pergunta',
  templateUrl: './form-pergunta.component.html',
  styleUrls: ['./form-pergunta.component.css'],
})
export class FormPerguntaComponent {
  titulo_pergunta: string = '';
  descricao_pergunta: string = '';
  idGoogle?: string | null = '';

  constructor(
    private perguntaService: PerguntaService,
    private authService: AuthService
  ) {}

  pergunta: CadastroPergunta = {
    titulo_pergunta: this.titulo_pergunta,
    descricao_pergunta: this.descricao_pergunta,
    data_pergunta: Date.now(),
    usuario: {
      idGoogle: this.authService.extrairNomeIdGoogleDoUsuario(),
    },
  };

  enviarPergunta(form: NgForm) {
    console.log(this.idGoogle);

    this.perguntaService.cadastrarPergunta(this.pergunta).subscribe(() => {});

    form.reset();
    location.href = 'http://localhost:4200/lista';
  }
}
