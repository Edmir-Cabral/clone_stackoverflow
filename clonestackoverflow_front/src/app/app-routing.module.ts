import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PerguntaComponent } from './views/pergunta/pergunta.component';
import { ListaDePerguntasComponent } from './views/lista-de-perguntas/lista-de-perguntas.component';

const routes: Routes = [
  { path: 'lista', component: ListaDePerguntasComponent },
  { path: 'pergunta/:id', component: PerguntaComponent },
  { path: '', redirectTo: '/lista', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
