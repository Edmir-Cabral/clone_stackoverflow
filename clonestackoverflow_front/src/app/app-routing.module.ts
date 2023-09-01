import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormPerguntaComponent } from './views/form-pergunta/form-pergunta.component';
import { ListaDePerguntasComponent } from './views/lista-de-perguntas/lista-de-perguntas.component';
import { PerguntaComponent } from './views/pergunta/pergunta.component';

const routes: Routes = [
  { path: 'lista', component: ListaDePerguntasComponent },
  { path: 'pergunta/:id', component: PerguntaComponent },
  { path: 'nova-pergunta', component: FormPerguntaComponent },
  { path: '', redirectTo: '/lista', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
