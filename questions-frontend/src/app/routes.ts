import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastraQuestoesComponent } from './cadastra-questoes/cadastra-questoes.component';
import { GeraProvaComponent } from './gera-prova/gera-prova.component';
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
        title: 'Cadastra Questões',
        children: [
            { path: 'processa-questoes', component: ProcessaQuestoesComponent, outlet: 'processa' },
            { path: 'visualiza-questoes', component: VisualizaQuestoesComponent, outlet: 'visualiza' }
        ]
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
