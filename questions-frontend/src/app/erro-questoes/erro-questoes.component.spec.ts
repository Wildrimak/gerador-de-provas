import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErroQuestoesComponent } from './erro-questoes.component';

describe('ErroQuestoesComponent', () => {
  let component: ErroQuestoesComponent;
  let fixture: ComponentFixture<ErroQuestoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ErroQuestoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErroQuestoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
