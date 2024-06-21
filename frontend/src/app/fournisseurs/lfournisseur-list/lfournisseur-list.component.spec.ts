import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LfournisseurListComponent } from './lfournisseur-list.component';

describe('LfournisseurListComponent', () => {
  let component: LfournisseurListComponent;
  let fixture: ComponentFixture<LfournisseurListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LfournisseurListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LfournisseurListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
