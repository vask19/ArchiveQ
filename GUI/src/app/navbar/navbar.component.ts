import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  appName: string = 'ArchiveQ';
  isSidenavOpen: boolean = false;
  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  toggleSidenav() {
    console.log('toggleSidenav() вызван');
    this.isSidenavOpen = !this.isSidenavOpen;
  }
}
