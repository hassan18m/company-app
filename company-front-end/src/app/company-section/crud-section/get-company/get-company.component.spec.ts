import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCompanyComponent } from './get-company.component';

describe('GetCompanyComponent', () => {
  let component: GetCompanyComponent;
  let fixture: ComponentFixture<GetCompanyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetCompanyComponent]
    });
    fixture = TestBed.createComponent(GetCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
