import { Component } from '@angular/core';
import { CepService } from './cep-service';

@Component({
  selector: 'app-cep',
  imports: [],
  templateUrl: './cep.html',
  styleUrl: './cep.css'
})
export class Cep {

  cep: any;
  logradouro: any;
  bairro: any;
  cidade: any;
  uf: any;

  constructor(private cepService: CepService){

  }

  public buscarCep(){
    this.cepService.consultaCep().then(resposta => {
      let retorno: any = resposta;
      //alert(retorno.logradouro);
      this.logradouro = retorno.logradouro;
      this.cidade = retorno.localidade;
    })
  }

}
