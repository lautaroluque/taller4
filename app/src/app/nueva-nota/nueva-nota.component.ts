import { Component, OnInit } from '@angular/core';
import { NotaService } from '../nota.service';
import { Nota } from '../nota';

@Component({
  selector: 'app-nueva-nota',
  templateUrl: './nueva-nota.component.html',
  styleUrls: ['./nueva-nota.component.css']
})
export class NuevaNotaComponent implements OnInit {
  
  constructor(public notaService: NotaService) { }

  ngOnInit() {
  }

  createNota(){
    let tempNota = new Nota();
    tempNota.dueño = sessionStorage.getItem('username');
    this.notaService.postNota(tempNota).subscribe(notaCreada => this.notaService.editNota(notaCreada));
  }
}
