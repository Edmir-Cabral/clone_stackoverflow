import { Usuario } from './usuario.model';
import { Pergunta } from './pergunta.model';
export interface Resposta{
   id: number;
   descricao_resposta: String;
   data_resposta: Date;
   usuario: Usuario;
   pergunta: Pergunta;
}
