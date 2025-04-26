import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-visualiza-questoes',
  imports: [CommonModule],
  templateUrl: './visualiza-questoes.component.html',
  styleUrl: './visualiza-questoes.component.css'
})
export class VisualizaQuestoesComponent {
  @Input() questoes: string = '';
  @Input() gabarito: string = '';
}
