import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ItemsToRequestComponent } from './itemsToRequest/itemsToRequest.component';
import { EmployeesComponent } from '../admin/employees/employees.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Emanuele
 * 
 * @see UserRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent, ItemsToRequestComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }