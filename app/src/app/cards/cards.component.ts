import { Component, OnInit } from '@angular/core';
import { Nota } from '../nota';
import { NotaService } from '../nota.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  notas: Nota[];
  constructor(private notaService: NotaService) { }

  ngOnInit() {
    this.getNotas();
  }

  getNotas(): void {
    this.notaService.getNotas().subscribe(notas => this.notas = notas);
  }
}