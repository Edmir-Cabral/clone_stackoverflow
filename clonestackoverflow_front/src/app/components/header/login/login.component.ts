import { Component, HostListener} from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  menuLoginAberto = false;

  nomeUsuario: string | null;

  constructor(public authService: AuthService) {
    this.nomeUsuario = authService.extrairNomeUsuarioDoToken();
  }

  alternarMenuLogin() {
    this.menuLoginAberto = !this.menuLoginAberto;
  }

  @HostListener('document:click', ['$event'])
  onClick(event: MouseEvent) {
    if (!event.target) return;

    const clickedElement = event.target as HTMLElement;

    if (!clickedElement.closest('.login-menu')) {
      this.menuLoginAberto = false;
    }
  }

  fazerLogout(): void {
    this.authService.logout();
  }
}
