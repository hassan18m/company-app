import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanySectionComponent } from './company-section.component';

describe('CompanySectionComponent', () => {
  let component: CompanySectionComponent;
  let fixture: ComponentFixture<CompanySectionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompanySectionComponent]
    });
    fixture = TestBed.createComponent(CompanySectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
