import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';

/**
 * Componente della dashboard user. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  user: UserDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    localStorage.setItem('currentUser', JSON.stringify(this.user));
  }

  default(){
    if(this.user.username === this.user.employee.firstName+"_"+this.user.employee.lastName
      || this.user.password === this.user.employee.fiscalCode){
        alert("Attenzione: il tuo username e/o password sono impostate ai valori di default." +
        + "Consigliamo di aggiornarle.")
      }
    
  }

}
