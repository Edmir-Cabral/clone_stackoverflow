import { SharedService } from './../../../services/shared.service';
import { Pergunta } from 'src/app/models/pergunta.model';
import { PerguntaService } from 'src/app/services/pergunta.service';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  searchTerm: string = '';
  showAllResults: boolean = true;
  constructor(private perguntaService: PerguntaService, private sharedService: SharedService) { }

  search() {
    if (this.searchTerm.length > 0) {
      this.perguntaService.buscaPorTitulo(this.searchTerm).subscribe((resultados: any) => {
        this.sharedService.setSearchResults(resultados); // Atualiza os resultados no serviço compartilhado
        //console.log(resultados);
      });
    } else {
      this.perguntaService.todasPerguntas().subscribe((resultados: any) => {
        this.sharedService.setSearchResults(resultados);
       // console.log(resultados);
      });
    }
  }

}
