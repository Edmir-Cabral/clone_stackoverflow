import { Resposta } from './resposta.model';
import { Pergunta } from './pergunta.model';

export interface Usuario {
    id: number;
    idGoogle: String;
    email: String;
    nome: String;
    data_criacao: Date;
    pergunta: Pergunta;
    resposta: Resposta;
}