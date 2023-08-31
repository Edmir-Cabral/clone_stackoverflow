import { Resposta } from './resposta.model';
import { Pergunta } from './pergunta.model';

export interface Usuario {
    idGoogle: String;
    email: String;
    nome: String;
    data_criacao: Date;
    perguntas: Pergunta[];
    respostas: Resposta[];
}