import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastraQuestoesComponent } from './cadastra-questoes/cadastra-questoes.component'
import { GeraProvaComponent } from './gera-prova/gera-prova.component'

const routeConfig: Routes = [
    {
        path: '',
        component: HomeComponent,
        title: 'Inicio',
    },
    {
        path: 'cadastra-questoes',
        component: CadastraQuestoesComponent,
        title: 'Cadastra Questoes',
    },
    {
        path: 'gera-prova',
        component: GeraProvaComponent,
        title: 'Gera Prova',
    },
    {
        path: '**',
        redirectTo: '',
        pathMatch: 'full'
    }
];
export default routeConfig;
