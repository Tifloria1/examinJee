import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigneCmdComponent } from './ligne-cmd.component';

describe('LigneCmdComponent', () => {
  let component: LigneCmdComponent;
  let fixture: ComponentFixture<LigneCmdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LigneCmdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LigneCmdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
