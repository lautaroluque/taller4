import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorNotaComponent } from './editor-nota.component';

describe('EditorNotaComponent', () => {
  let component: EditorNotaComponent;
  let fixture: ComponentFixture<EditorNotaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditorNotaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorNotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
