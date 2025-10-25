import { ChangeDetectionStrategy, Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { TagsSelector } from '../tags-selector/tags-selector';

@Component({
  selector: 'app-filtra-questoes',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, TagsSelector],
  templateUrl: './filtra-questoes.html',
  styleUrl: './filtra-questoes.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FiltraQuestoes {
  private readonly fb = inject(FormBuilder);

  protected readonly filterForm = this.fb.group({
    enunciado: [''],
    quantidade: [null as number | null],
    nivel: [null as number | null, [Validators.min(1), Validators.max(9)]],
  });

  protected applyFilters(): void {
    console.log('Filtros aplicados:', this.filterForm.value);
  }

  protected clearFilters(): void {
    this.filterForm.reset();
  }
}
