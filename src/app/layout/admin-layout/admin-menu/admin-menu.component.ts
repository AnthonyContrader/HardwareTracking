import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isEmployeeCollapsed = false;
  isItemCollapsed = false;
  isItemLentCollapsed = false;
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

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  employeescollapse() {
    if (this.isEmployeeCollapsed === false) {
      this.isEmployeeCollapsed = true;
    } else { this.isEmployeeCollapsed = false; }
  }

  itemscollapse() {
    if (this.isItemCollapsed === false) {
      this.isItemCollapsed = true;
    } else { this.isItemCollapsed = false; }
  }

  itemslentcollapse() {
    if (this.isItemLentCollapsed === false) {
      this.isItemLentCollapsed = true;
    } else { this.isItemLentCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
