import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEleveComponent } from './admin-eleve.component';

describe('AdminEleveComponent', () => {
  let component: AdminEleveComponent;
  let fixture: ComponentFixture<AdminEleveComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminEleveComponent]
    });
    fixture = TestBed.createComponent(AdminEleveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
