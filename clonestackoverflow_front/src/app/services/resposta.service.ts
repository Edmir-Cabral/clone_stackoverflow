import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Resposta } from '../models/resposta.model';

@Injectable({
  providedIn: 'root'
})
export class RespostaService {
  private readonly baseUrl= "http://localhost:8080/api/respostas/"
  constructor(private http: HttpClient) { }
  read(): Observable<Resposta[]>{
    return this.http.get<Resposta[]>(this.baseUrl);
  }

  readById(id?: number): Observable<Resposta>{
    const url = `${this.baseUrl}${id}`
    return this.http.get<Resposta>(url);
  }
}