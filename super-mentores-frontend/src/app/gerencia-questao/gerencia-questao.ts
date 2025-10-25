import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FiltraQuestoes } from '../filtra-questoes/filtra-questoes';

@Component({
  selector: 'app-gerencia-questao',
  imports: [CommonModule, FiltraQuestoes],
  templateUrl: './gerencia-questao.html',
  styleUrl: './gerencia-questao.css'
})
export class GerenciaQuestao {
  protected readonly filtersOpen = signal(false);

  protected toggleFilters() {
    this.filtersOpen.update(v => !v);
  }

}
