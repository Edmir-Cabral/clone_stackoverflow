import { Pergunta } from 'src/app/models/pergunta.model';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SharedService {
  private searchResultsSubject = new Subject<Pergunta[]>();
  searchResults$ = this.searchResultsSubject.asObservable();
  setSearchResults(results: Pergunta[]) {
    this.searchResultsSubject.next(results);
  }
}
