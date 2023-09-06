import { SharedService } from './../../../services/shared.service';
import { Pergunta } from 'src/app/models/pergunta.model';
import { PerguntaService } from 'src/app/services/pergunta.service';
import { Component} from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  textoDaBusca: string = '';
  resultadoDaBusca: boolean = true;
  constructor(private perguntaService: PerguntaService, private sharedService: SharedService) { }

  search() {
    if (this.textoDaBusca.length > 0) {
      this.perguntaService.buscaPorTitulo(this.textoDaBusca).subscribe((resultados: Pergunta[]) => {
        this.sharedService.buscar(resultados); 
      });
    } else {
      this.perguntaService.buscarTodas().subscribe((resultados: Pergunta[]) => {
        this.sharedService.buscar(resultados);
      });
    }
  }

}
