import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ToolbarService {
  public editor: boolean;

  constructor() { }

  public setEditor(value: boolean){
    this.editor = value;
  }

  public isEditor(){
    return this.editor;
  }
}
