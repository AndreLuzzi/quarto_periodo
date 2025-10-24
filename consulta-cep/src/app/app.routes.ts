import { Routes } from '@angular/router';
import { Cep } from './cep/cep';
import { BoasVindas } from './boas-vindas/boas-vindas';
import { Home} from './home/home';
import { Sobre} from './sobre/sobre';
import { ProdutoService } from './produto';
import { ListaProdutos } from './lista-produtos/lista-produtos';
import { UsuarioService } from './usuario';

export const routes: Routes = [
    {path: 'cep', component: Cep},
    {path: 'boasvindas', component: BoasVindas},
    { path: 'home', component: Home},
    { path: 'sobre', component: Sobre},
    { path: 'produto', component: ListaProdutos},
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: '', component: UsuarioService}
];



