import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { ToolbarService } from '../toolbar.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(public loginService: LoginService, public toolbarService: ToolbarService) { }

  titulo = 'Notas';

  ngOnInit() {
  }
}
