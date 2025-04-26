import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProcessaQuestoesComponent } from '../processa-questoes/processa-questoes.component';
import { VisualizaQuestoesComponent } from '../visualiza-questoes/visualiza-questoes.component';
import { ErroQuestoesComponent } from '../erro-questoes/erro-questoes.component';
import { ProcessaQuestoesService } from '../services/processa-questoes.service ';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastra-questoes',
  standalone: true,
  imports: [CommonModule, FormsModule, ProcessaQuestoesComponent, VisualizaQuestoesComponent, ErroQuestoesComponent],
  templateUrl: './cadastra-questoes.component.html',
  styleUrl: './cadastra-questoes.component.css'
})
export class CadastraQuestoesComponent {
  semErros = true;
  questoes: string = '';
  gabarito: string = '';

  constructor(private questaoService: ProcessaQuestoesService) {}

  onProcessar(data: { questoes: string; gabarito: string }): void {
    this.questoes = data.questoes;
    this.gabarito = data.gabarito;

    this.questaoService.processarQuestoes(this.questoes, this.gabarito).subscribe({
      next: (response) => {
        console.log('Processado com sucesso:', response);
        this.semErros = true;
      },
      error: (erro) => {
        console.error('Erro ao processar:', erro);
        this.semErros = false;
      }
    });
  }
}
