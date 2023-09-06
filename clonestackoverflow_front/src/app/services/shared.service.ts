import { Pergunta } from 'src/app/models/pergunta.model';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SharedService {
  private resultadoDaBuscaSubject = new Subject<Pergunta[]>();
  resultadoDaBusca = this.resultadoDaBuscaSubject.asObservable();

  buscar(results: Pergunta[]) {
    this.resultadoDaBuscaSubject.next(results);
  }
}