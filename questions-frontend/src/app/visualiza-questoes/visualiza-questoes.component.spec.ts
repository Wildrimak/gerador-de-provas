import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizaQuestoesComponent } from './visualiza-questoes.component';

describe('VisualizaQuestoesComponent', () => {
  let component: VisualizaQuestoesComponent;
  let fixture: ComponentFixture<VisualizaQuestoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizaQuestoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizaQuestoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
