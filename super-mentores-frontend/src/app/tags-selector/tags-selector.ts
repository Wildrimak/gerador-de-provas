import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-tags-selector',
  imports: [CommonModule, FormsModule],
  templateUrl: './tags-selector.html',
  styleUrl: './tags-selector.css'
})
export class TagsSelector {
  // exemplo de tags estáticas — em uma versão real, viria da API
  protected allTags = ['algoritmos','matematica','probabilidade','geometria','fisica','quimica','historia'];
  protected query = '';
  protected selected: string[] = [];

  protected toggle(tag: string) {
    const idx = this.selected.indexOf(tag);
    if (idx >= 0) {
      this.selected = this.selected.filter(t => t !== tag);
    } else {
      this.selected = [...this.selected, tag];
    }
  }

  protected isSelected(tag: string) {
    return this.selected.includes(tag);
  }

  protected filtered() {
    const q = this.query.toLowerCase().trim();
    if (!q) return this.allTags;
    return this.allTags.filter(t => t.toLowerCase().includes(q));
  }
}
