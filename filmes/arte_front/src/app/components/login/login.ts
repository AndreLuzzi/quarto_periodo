import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.services';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  email = '';
  senha = '';

  constructor(private auth: AuthService, private router: Router) {}

  onLogin() {
    this.auth.login(this.email, this.senha).subscribe({
      next: (res) => {
        if (res.sucesso) {
          this.auth.setLogado(true);
          this.router.navigate(['/obra']);
        } else {
          alert('Usuário ou senha inválidos!');
        }
      },
      error: () => {
        alert('Erro ao conectar com o servidor!');
      }
    });
  }
}


