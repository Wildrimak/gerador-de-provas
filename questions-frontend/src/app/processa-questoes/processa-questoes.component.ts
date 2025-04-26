import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-processa-questoes',
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './processa-questoes.component.html',
  styleUrl: './processa-questoes.component.css'
})
export class ProcessaQuestoesComponent {
  
  questoes: string = '';
  gabarito: string = '';

  @Output() processar = new EventEmitter<{ questoes: string; gabarito: string }>();

  onProcessar(): void {
    this.processar.emit({
      questoes: this.questoes,
      gabarito: this.gabarito
    });
  }
}
