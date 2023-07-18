import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupportticketlistComponent } from './supportticketlist.component';

describe('SupportticketlistComponent', () => {
  let component: SupportticketlistComponent;
  let fixture: ComponentFixture<SupportticketlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupportticketlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SupportticketlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
