import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastraQuestoesComponent } from './cadastra-questoes/cadastra-questoes.component'
import { GeraProvaComponent } from './gera-prova/gera-prova.component'
import { ProcessaQuestoesComponent } from './processa-questoes/processa-questoes.component';
import { VisualizaQuestoesComponent } from './visualiza-questoes/visualiza-questoes.component';

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
        path: 'processa-questoes',
        component: ProcessaQuestoesComponent,
        title: 'Processa Questoes',
    },
    {
        path: 'visualiza-questoes',
        component: VisualizaQuestoesComponent,
        title: 'Visualiza Questoes',
    },
    {
        path: '**',
        redirectTo: '',
        pathMatch: 'full'
    }
];
export default routeConfig;
