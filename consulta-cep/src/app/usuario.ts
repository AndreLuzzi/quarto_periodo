import { Injectable } from '@angular/core';
@Injectable({
providedIn: 'root'
})
export class UsuarioService {
listar() {
return [
{ nome: 'Ana', email: 'ana@email.com' },
{ nome: 'Bruno', email: 'bruno@email.com' },
{ nome: 'Carla', email: 'carla@email.com' }
];
}
}
