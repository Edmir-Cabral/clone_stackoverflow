import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pergunta } from '../models/pergunta.model';

@Injectable({
  providedIn: 'root'
})
export class PerguntaService {

  private readonly baseUrl= "http://localhost:8080/api/perguntas/"
  constructor(private http: HttpClient) { }

  read(): Observable<Pergunta[]>{
    return this.http.get<Pergunta[]>(this.baseUrl);
  }

  readById(id?: number): Observable<Pergunta>{
    const url = `${this.baseUrl}${id}`
    return this.http.get<Pergunta>(url);
  }

  buscaPorTitulo(titulo?: String): Observable<Pergunta>{
    const url = `${this.baseUrl}titulo?tituloPergunta=${titulo}`
    return this.http.get<Pergunta>(url);
  }
}