import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../auth.service";
import {DocumentService} from "../../document.service";
import {Router} from "@angular/router";
import {DocumentComponent} from "../../document/document.component";

@Component({
  selector: 'app-users-page',
  templateUrl: './users-page.component.html',
  styleUrls: ['./users-page.component.scss']
})
export class UsersPageComponent {

  constructor(private authService: AuthService,
              private router: Router) { }

  logout(): void {
    this.authService.logout();
  }

  protected readonly DocumentService = DocumentService;
  protected readonly DocumentComponent = DocumentComponent;
  protected readonly document = document;
}
