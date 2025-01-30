import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastraQuestoesComponent } from './cadastra-questoes.component';

describe('CadastraQuestoesComponent', () => {
  let component: CadastraQuestoesComponent;
  let fixture: ComponentFixture<CadastraQuestoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastraQuestoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastraQuestoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
