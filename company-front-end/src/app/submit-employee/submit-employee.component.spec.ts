import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitEmployeeComponent } from './submit-employee.component';

describe('SubmitEmployeeComponent', () => {
  let component: SubmitEmployeeComponent;
  let fixture: ComponentFixture<SubmitEmployeeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SubmitEmployeeComponent]
    });
    fixture = TestBed.createComponent(SubmitEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
