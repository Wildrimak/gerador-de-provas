import { Component } from '@angular/core';
import { ProcessaQuestoesComponent } from '../processa-questoes/processa-questoes.component';
import { VisualizaQuestoesComponent } from '../visualiza-questoes/visualiza-questoes.component';
import { ErroQuestoesComponent } from '../erro-questoes/erro-questoes.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastra-questoes',
  imports: [CommonModule, ProcessaQuestoesComponent, VisualizaQuestoesComponent, ErroQuestoesComponent],
  templateUrl: './cadastra-questoes.component.html',
  styleUrl: './cadastra-questoes.component.css'
})
export class CadastraQuestoesComponent {
  semErros = true;
}
