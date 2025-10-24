/*import { FormsModule } from "@angular/forms";
import { Component } from "@angular/core";

@Component({
selector: 'app-boas-vindas',
imports: [FormsModule],
templateUrl: './boas-vindas.html',
styleUrl: './boas-vindas.css'
})

export class BoasVindas {
  nome: string = 'Aluno';

}*/

import { Component } from '@angular/core';
import { MensagemService } from '../mensagem-service';
@Component({
selector: 'app-boas-vindas',
templateUrl: './boas-vindas.html'
})
export class BoasVindas{
mensagem: string = '';
constructor(private mensagemService: MensagemService) {
this.mensagem = this.mensagemService.obterMensagem();
}
}
