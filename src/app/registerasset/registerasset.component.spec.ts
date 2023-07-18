import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterassetComponent } from './registerasset.component';

describe('RegisterassetComponent', () => {
  let component: RegisterassetComponent;
  let fixture: ComponentFixture<RegisterassetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterassetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterassetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
