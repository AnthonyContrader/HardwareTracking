import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ItemsToRequestComponent } from './itemsToRequest/itemsToRequest.component';
import { ItemsToReturnComponent } from './itemsToReturn/itemsToReturn.component';
import { EditProfileComponent} from '../user/edit-profile/edit-profile.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Emanuele
 * 
 * @see UserRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent, ItemsToRequestComponent, 
    ItemsToReturnComponent, EditProfileComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
