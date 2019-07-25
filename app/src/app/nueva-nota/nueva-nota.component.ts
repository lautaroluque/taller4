import { Component, OnInit } from '@angular/core';
import { NotaService } from '../nota.service';
import { Nota } from '../nota';

@Component({
  selector: 'app-nueva-nota',
  templateUrl: './nueva-nota.component.html',
  styleUrls: ['./nueva-nota.component.css']
})
export class NuevaNotaComponent implements OnInit {
  private nota: Nota;
  constructor(public notaService: NotaService) { }

  ngOnInit() {
  }

  createNota(){
    let tempNota = new Nota();
    this.notaService.postNota(tempNota).subscribe(notaCreada => this.nota = notaCreada);
    this.notaService.editNota(this.nota);
  }
}
