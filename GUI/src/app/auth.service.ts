import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  users: any[] = [
    {
      id: 1,
      name: 'David',
      username: 'david',
      password: 'david'
    },
    {
      id: 2,
      name: 'Vasyl',
      username: 'vasyl',
      password: 'vasyl'
    }
  ];
  session: any;

  constructor(private router: Router) {
    let session: any = localStorage.getItem('session')
    if (session) {
      session = JSON.parse(session);
    }

    this.session = session;
  }

  login(username: string, password: string) {
    let user = this.users.find((u) =>
      u.username === username && u.password === password);
    if (user) {
        this.session = user;
        localStorage.setItem('session', JSON.stringify(this.session));
    }

    return user;
  }

  logout() {
    this.session = undefined;
    localStorage.removeItem('session');
    this.router.navigateByUrl('/');
  }
}
