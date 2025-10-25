import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TagsSelector } from '../tags-selector/tags-selector';

@Component({
  selector: 'app-filtra-questoes',
  imports: [CommonModule, FormsModule, TagsSelector],
  templateUrl: './filtra-questoes.html',
  styleUrl: './filtra-questoes.css'
})
export class FiltraQuestoes {
  enunciado = '';
  quantidade: number | null = null;
  nivel: number | null = null;
}
