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
      this.isEmployeeCollapsed = false;
      this.isItemCollapsed = false;
      this.isItemLentCollapsed = false;
      this.isAccountCollapsed = false;
    } else { this.isUserCollapsed = false; }
  }

  employeescollapse() {
    if (this.isEmployeeCollapsed === false) {
      this.isUserCollapsed = false;
      this.isEmployeeCollapsed = true;
      this.isItemCollapsed = false;
      this.isItemLentCollapsed = false;
      this.isAccountCollapsed = false;
    } else { this.isEmployeeCollapsed = false; }
  }

  itemscollapse() {
    if (this.isItemCollapsed === false) {
      this.isUserCollapsed = false;
      this.isEmployeeCollapsed = false;
      this.isItemCollapsed = true;
      this.isItemLentCollapsed = false;
      this.isAccountCollapsed = false;
    } else { this.isItemCollapsed = false; }
  }

  itemslentcollapse() {
    if (this.isItemLentCollapsed === false) {
      this.isUserCollapsed = false;
      this.isEmployeeCollapsed = false;
      this.isItemCollapsed = false;
      this.isItemLentCollapsed = true;
      this.isAccountCollapsed = false;
    } else { this.isItemLentCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isUserCollapsed = false;
      this.isEmployeeCollapsed = false;
      this.isItemCollapsed = false;
      this.isItemLentCollapsed = false;
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
