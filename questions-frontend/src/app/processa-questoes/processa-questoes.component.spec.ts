import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessaQuestoesComponent } from './processa-questoes.component';

describe('ProcessaQuestoesComponent', () => {
  let component: ProcessaQuestoesComponent;
  let fixture: ComponentFixture<ProcessaQuestoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProcessaQuestoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcessaQuestoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
