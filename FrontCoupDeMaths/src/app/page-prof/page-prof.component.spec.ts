import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageProfComponent } from './page-prof.component';

describe('PageProfComponent', () => {
  let component: PageProfComponent;
  let fixture: ComponentFixture<PageProfComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PageProfComponent]
    });
    fixture = TestBed.createComponent(PageProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
