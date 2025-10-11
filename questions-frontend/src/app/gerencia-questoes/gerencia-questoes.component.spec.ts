import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaQuestoesComponent } from './gerencia-questoes.component';

describe('GerenciaQuestoesComponent', () => {
  let component: GerenciaQuestoesComponent;
  let fixture: ComponentFixture<GerenciaQuestoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GerenciaQuestoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GerenciaQuestoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
