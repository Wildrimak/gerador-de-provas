import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-cadastra-questoes',
  imports: [CommonModule, RouterModule],
  templateUrl: './cadastra-questoes.component.html',
  styleUrl: './cadastra-questoes.component.css'
})
export class CadastraQuestoesComponent {
  constructor(private router: Router) {}

  ngOnInit() {
    this.router.navigate([{ outlets: { processa: ['processa-questoes'], visualiza: ['visualiza-questoes'] } }]);
  }
}
