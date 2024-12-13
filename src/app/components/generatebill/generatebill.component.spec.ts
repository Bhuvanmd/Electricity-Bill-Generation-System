import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneratebillComponent } from './generatebill.component';

describe('GeneratebillComponent', () => {
  let component: GeneratebillComponent;
  let fixture: ComponentFixture<GeneratebillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GeneratebillComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeneratebillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
