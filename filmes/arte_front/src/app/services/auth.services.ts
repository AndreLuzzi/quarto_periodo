import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/login'; // coloque sua rota real
  private logado = false;

  constructor(private http: HttpClient) {}

  login(email: string, senha: string): Observable<any> {
    return this.http.post(this.apiUrl, { email, senha });
  }

  setLogado(status: boolean) {
    this.logado = status;
  }

  estaLogado(): boolean {
    return this.logado;
  }
}
