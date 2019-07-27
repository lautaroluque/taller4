import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import * as BalloonEditor from '@ckeditor/ckeditor5-build-balloon';
import { Nota } from '../nota';
import { ChangeEvent } from '@ckeditor/ckeditor5-angular';
import { NotaService } from '../nota.service';
import { ActivatedRoute } from '@angular/router';
import { ToolbarService } from '../toolbar.service';

@Component({
  selector: 'app-editor-nota',
  templateUrl: './editor-nota.component.html',
  styleUrls: ['./editor-nota.component.css']
})
export class EditorNotaComponent implements OnInit, OnDestroy {

  @Input() public nota: Nota;

  public Editor = BalloonEditor;

  constructor(public notaService: NotaService, private route: ActivatedRoute, private toolbarService: ToolbarService) {
      this.nota = new Nota();
  }

  ngOnInit() {
    this.toolbarService.setEditor(true);
    let id = this.route.snapshot.paramMap.get('id');
    let username = sessionStorage.getItem('username');
    this.notaService.getNota(username, id).subscribe(nota => this.nota = nota);
  }

  ngOnDestroy(): void {
    this.toolbarService.setEditor(false);
  }

  public onChange({editor}: ChangeEvent) {
    this.nota.contenido = editor.getData();
    this.notaService.putNota(this.nota).subscribe();
  }
}
