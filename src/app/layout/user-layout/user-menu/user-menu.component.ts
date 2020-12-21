import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {

  isRequestCollapsed = false;
  isReturnCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  requestscollapse() {
    if (this.isRequestCollapsed === false) {
      this.isRequestCollapsed = true;
    } else { this.isRequestCollapsed = false; }
  }

  returnscollapse() {
    if (this.isReturnCollapsed === false) {
      this.isReturnCollapsed = true;
    } else { this.isReturnCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
