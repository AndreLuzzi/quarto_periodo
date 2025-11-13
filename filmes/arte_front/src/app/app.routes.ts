import { RouterModule, Routes } from '@angular/router';
import { ObraServices } from './services/obra-services';
import { ObraForm } from './obra/obra-form/obra-form';
import { Obra } from './obra/obra';
import { Login } from './login/login';


export const routes: Routes = [
    
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: Login },
    { path: 'form', component: ObraForm },
    { path: 'obra', component: Obra },
    { path: 'obra/editar/:id', component: ObraForm }
];

//export const routes: Routes = [
    
    //{ path: '', redirectTo: 'obra', pathMatch: 'full' },
    //{ path: 'form', component: ObraForm },
    //{ path: 'obra', component: Obra },
  //  { path: 'obra/editar/:id', component: ObraForm }
//];


