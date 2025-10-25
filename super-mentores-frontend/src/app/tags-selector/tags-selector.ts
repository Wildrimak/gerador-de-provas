import { ChangeDetectionStrategy, Component, computed, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tags-selector',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './tags-selector.html',
  styleUrl: './tags-selector.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TagsSelector {
  protected readonly allTags = signal<string[]>(['Java', 'Angular', 'Spring Boot', 'TypeScript', 'SQL', 'Docker', 'AWS']);
  protected readonly query = signal('');
  protected readonly selected = signal<string[]>([]);

  protected readonly filtered = computed(() => {
    const q = this.query().toLowerCase();
    if (!q) {
      return this.allTags();
    }
    return this.allTags().filter(tag => tag.toLowerCase().includes(q));
  });

  protected onQueryChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.query.set(input.value);
  }

  protected isSelected(tag: string): boolean {
    return this.selected().includes(tag);
  }

  protected toggle(tag: string): void {
    this.selected.update(currentSelected => {
      if (currentSelected.includes(tag)) {
        return currentSelected.filter(t => t !== tag);
      } else {
        return [...currentSelected, tag];
      }
    });
  }
}