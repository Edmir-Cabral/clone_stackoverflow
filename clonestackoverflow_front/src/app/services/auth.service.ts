import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  isLoggedIn: boolean;

  constructor(private cookieService: CookieService) {
    this.isLoggedIn = this.cookieService.check('authToken');
  }

  extrairNomeUsuarioDoToken(): string | null {
    const token = this.cookieService.get('authToken');
    if (token) {
      const decodificarToken: any = jwt_decode(token);
      return decodificarToken.username;
    }
    return null;
  }

  extrairNomeIdGoogleDoUsuario(): string {
    const token = this.cookieService.get('authToken');
    const decodificarToken: any = jwt_decode(token);
    return decodificarToken.sub;
  }

  logout() {
    this.cookieService.delete('authToken');
    window.location.href = 'http://localhost:8080'; // Redirecionar para a página de origem
  }
}
