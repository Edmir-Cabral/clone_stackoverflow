import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Resposta } from '../models/resposta.model';
import { EnviarResposta } from '../views/resposta/resposta.component';

@Injectable({
  providedIn: 'root'
})
export class RespostaService {
  private readonly baseUrl= "http://localhost:8080/api/respostas"
  constructor(private http: HttpClient) { }
  read(): Observable<Resposta[]>{
    return this.http.get<Resposta[]>(this.baseUrl);
  }

  readById(id: number): Observable<Resposta>{
    const url = `http://localhost:8080/api/respostas/${id}`
    return this.http.get<Resposta>(url);
  }

  postResposta(resposta: EnviarResposta): Observable<Resposta> {
    return this.http.post<Resposta>("http://localhost:8080/api/respostas", resposta);
  }

  postRespostaModel(resposta: Resposta): Observable<Resposta> {
    return this.http.post<Resposta>("http://localhost:8080/api/respostas", resposta);
  }
}
