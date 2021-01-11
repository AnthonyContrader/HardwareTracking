import { Component, OnInit } from '@angular/core';
import { UsersComponent } from 'src/app/admin/users/users.component';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user: UserDTO;

  constructor(private service: UserService) { }

  usersComponent: UsersComponent = new UsersComponent(this.service);

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  update(user: UserDTO){
    this.usersComponent.update(user);
    alert("La modifica e' stata apporta con successo! \n Effettuare il login con le nuove credenziali")
  }

}
