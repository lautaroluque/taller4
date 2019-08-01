import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import * as BalloonEditor from '@ckeditor/ckeditor5-build-balloon';
import { Nota } from '../nota';
import { ChangeEvent } from '@ckeditor/ckeditor5-angular';
import { NotaService } from '../nota.service';
import { ActivatedRoute } from '@angular/router';
import { ToolbarService } from '../toolbar.service';
import { ImageService } from '../image.service';
import { MiUploadAdapter } from './upload-adapter'

@Component({
  selector: 'app-editor-nota',
  templateUrl: './editor-nota.component.html',
  styleUrls: ['./editor-nota.component.css']
})
export class EditorNotaComponent implements OnInit, OnDestroy {

  nota: Nota;
  username: string;
  public Editor = BalloonEditor;


  constructor(public notaService: NotaService, private route: ActivatedRoute, private toolbarService: ToolbarService, public imageService: ImageService) {
    this.nota = new Nota();
  }

  ngOnInit() {
    this.toolbarService.setEditor(true);
    let id = this.route.snapshot.paramMap.get('id');
    this.username = sessionStorage.getItem('username');
    this.notaService.getNota(this.username, id).subscribe(nota => this.nota = nota);
  }

  ngOnDestroy(): void {
    this.toolbarService.setEditor(false);
  }

  public guardarContenido({ editor }: ChangeEvent) {
    this.nota.contenido = editor.getData();

    this.notaService.putNota(this.nota).subscribe();
  }

  guardarTitulo() {
    this.notaService.putNota(this.nota).subscribe();
  }

  public listo($event) {
    $event.plugins.get('FileRepository').createUploadAdapter = (loader) => {
      return new MiUploadAdapter(loader, this.imageService, this.username);
    };
  }
}