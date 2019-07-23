import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nueva-nota',
  templateUrl: './nueva-nota.component.html',
  styleUrls: ['./nueva-nota.component.css']
})
export class NuevaNotaComponent implements OnInit {

  fabButtons = [{ icon: 'note_add' }];
  buttons = [];
  togglerState = 'inactive';
  constructor() { }

  ngOnInit() {
  }

  showItems() {
    this.togglerState = 'active';
    this.buttons = this.fabButtons;
  }

  hideItems() {
    this.togglerState = 'inactive';
    this.buttons = [];
  }

  onToggleFab() {
    this.buttons.length ? this.hideItems() : this.showItems();
  }
}
