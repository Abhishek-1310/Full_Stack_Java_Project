import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResolveticketComponent } from './resolveticket.component';

describe('ResolveticketComponent', () => {
  let component: ResolveticketComponent;
  let fixture: ComponentFixture<ResolveticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResolveticketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResolveticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
