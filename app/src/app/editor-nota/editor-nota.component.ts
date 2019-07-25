import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import * as BalloonBlockEditor from '@ckeditor/ckeditor5-build-balloon-block';
import { Nota } from '../nota';
import { ChangeEvent } from '@ckeditor/ckeditor5-angular';
import { NotaService } from '../nota.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToolbarService } from '../toolbar.service';

@Component({
  selector: 'app-editor-nota',
  templateUrl: './editor-nota.component.html',
  styleUrls: ['./editor-nota.component.css']
})
export class EditorNotaComponent implements OnInit, OnDestroy {

  @Input() public nota: Nota;

  public Editor = BalloonBlockEditor;

  constructor(public notaService: NotaService, 
    private route: ActivatedRoute, 
    private router: Router, 
    private toolbarService: ToolbarService) { }

  ngOnInit() {
    this.toolbarService.setEditor(true);
    let id = this.route.snapshot.paramMap.get('id');
    let username = sessionStorage.getItem('username');
    this.notaService.getNota(username, id).subscribe(notaRecibida => this.nota = notaRecibida);
  }

  ngOnDestroy(): void {
    this.toolbarService.setEditor(false);
  }
  public onChange( { editor }: ChangeEvent ) {
    const data = editor.getData();
    this.nota.contenido = data;
    this.notaService.putNota(this.nota).subscribe;
  }
}
