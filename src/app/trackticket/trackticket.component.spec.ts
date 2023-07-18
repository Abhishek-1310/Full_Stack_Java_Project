import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackticketComponent } from './trackticket.component';

describe('TrackticketComponent', () => {
  let component: TrackticketComponent;
  let fixture: ComponentFixture<TrackticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrackticketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrackticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
