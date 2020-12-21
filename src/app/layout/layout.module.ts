import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';
import { HeaderComponent } from './header/header.component';
import { UserLayoutComponent } from './user-layout/user-layout.component';
import { UserMenuComponent } from './user-layout/user-menu/user-menu.component';

import { RouterModule } from '@angular/router';

/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi 
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 *
 * @see UserLayoutComponent
 */
@NgModule({
  declarations: [AdminLayoutComponent, AdminMenuComponent, HeaderComponent, UserLayoutComponent, UserMenuComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }
