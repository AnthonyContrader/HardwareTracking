import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemsComponent } from '../admin/items/items.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';


/**
 * Modulo di routing dell'user. Qui ci sono i percorsi che un user può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Emanuele
 * 
 * @see UserLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
    { path: 'user-dashboard', component: UserLayoutComponent, children:[
    { path: '', component: UserDashboardComponent},
    { path: 'items', component: ItemsComponent}
  ]}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
