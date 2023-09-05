import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ListaDePerguntasComponent } from './views/lista-de-perguntas/lista-de-perguntas.component';

import { HttpClientModule } from '@angular/common/http';
import { MatListModule } from '@angular/material/list';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/header/login/login.component';
import { SearchComponent } from './components/header/search/search.component';
import { FormPerguntaComponent } from './views/form-pergunta/form-pergunta.component';
import { PerguntaComponent } from './views/pergunta/pergunta.component';
import { RespostaComponent } from './views/resposta/resposta.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    SearchComponent,
    ListaDePerguntasComponent,
    FormPerguntaComponent,
    PerguntaComponent,
    RespostaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatListModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
