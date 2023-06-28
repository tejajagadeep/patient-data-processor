import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SugarLevelComponent } from './sugar-level.component';

describe('SugarLevelComponent', () => {
  let component: SugarLevelComponent;
  let fixture: ComponentFixture<SugarLevelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SugarLevelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SugarLevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
