import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitCompanyComponent } from './submit-company.component';

describe('SubmitCompanyComponent', () => {
  let component: SubmitCompanyComponent;
  let fixture: ComponentFixture<SubmitCompanyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SubmitCompanyComponent]
    });
    fixture = TestBed.createComponent(SubmitCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
