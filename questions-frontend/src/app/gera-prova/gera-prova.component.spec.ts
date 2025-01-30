import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeraProvaComponent } from './gera-prova.component';

describe('GeraProvaComponent', () => {
  let component: GeraProvaComponent;
  let fixture: ComponentFixture<GeraProvaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GeraProvaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeraProvaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
