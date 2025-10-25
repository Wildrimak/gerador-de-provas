import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GerenciaQuestao } from './gerencia-questao/gerencia-questao';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GerenciaQuestao],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('super-mentores-frontend');
}
