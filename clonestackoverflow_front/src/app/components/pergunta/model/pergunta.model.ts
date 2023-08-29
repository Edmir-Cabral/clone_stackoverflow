import { Usuario } from './usuario.model';
export interface Pergunta{
    id: number;
    titulo_pergunta: String;
    descricao_pergunta: String;
    data_pergunta: Date;
    usuario: Usuario;        
}
