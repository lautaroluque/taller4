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
    let username = sessionStorage.getItem('username');
    this.notas = [];
    this.notaService.getNotas(username).subscribe(notas => this.notas = notas);
  }

  editNota(nota: Nota): void {
    this.notaService.editNota(nota);
  }

  getFirstLines(nota: Nota): string {
    var lineas = nota.contenido.split('</p>');
    if (lineas.length > 1){
      return lineas[0] + lineas [1];
    }
    else return lineas[0];
  }
}
