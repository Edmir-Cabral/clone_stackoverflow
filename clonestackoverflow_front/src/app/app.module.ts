import { ListaDePerguntasComponent } from './views/lista-de-perguntas/lista-de-perguntas.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/header/login/login.component';
import { SearchComponent } from './components/header/search/search.component';
import { HttpClientModule } from '@angular/common/http';
import { MatListModule } from '@angular/material/list';
<<<<<<< HEAD
import { FormPerguntaComponent } from './components/form-pergunta/form-pergunta.component';
=======
import { PerguntaComponent } from './views/pergunta/pergunta.component';
>>>>>>> 75e0fe942a26c50c16b3dad02025da946c858e8b

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    SearchComponent,
<<<<<<< HEAD
    PerguntaComponent,
    FormPerguntaComponent    
=======
    ListaDePerguntasComponent,
    PerguntaComponent    
>>>>>>> 75e0fe942a26c50c16b3dad02025da946c858e8b
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
