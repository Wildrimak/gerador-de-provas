import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastraQuestoesComponent } from './cadastra-questoes/cadastra-questoes.component';
import { GeraProvaComponent } from './gera-prova/gera-prova.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, title: 'Início' },
    { path: 'cadastra-questoes', component: CadastraQuestoesComponent, title: 'Cadastra Questões' },
    { path: 'gera-prova', component: GeraProvaComponent, title: 'Gera Prova' },
    { path: '**', redirectTo: '', pathMatch: 'full' }
];
