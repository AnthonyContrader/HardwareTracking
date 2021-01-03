import { Component, OnInit } from '@angular/core';
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

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  update(user: UserDTO){
    console.log(user.username + " " + user.password + " " + user.usertype);
    this.service.update(user).subscribe(() => this.user);
  }

}
