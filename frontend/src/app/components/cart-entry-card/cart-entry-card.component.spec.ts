import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartEntryCardComponent } from './cart-entry-card.component';

describe('CartEntryCardComponent', () => {
  let component: CartEntryCardComponent;
  let fixture: ComponentFixture<CartEntryCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartEntryCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartEntryCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
