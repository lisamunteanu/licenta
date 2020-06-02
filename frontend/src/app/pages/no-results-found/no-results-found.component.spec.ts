import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoResultsFoundComponent } from './no-results-found.component';

describe('NoResultsFoundComponent', () => {
  let component: NoResultsFoundComponent;
  let fixture: ComponentFixture<NoResultsFoundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoResultsFoundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoResultsFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
