import { Component, OnInit } from '@angular/core';
import { ItemLentService } from 'src/service/itemlent.service';
import { ItemLentDTO } from 'src/dto/itemlentdto';
import { EmployeeService } from 'src/service/employee.service';
import { EmployeeDTO } from 'src/dto/employeedto';

@Component({
  selector: 'app-itemstracking',
  templateUrl: './itemstracking.component.html',
  styleUrls: ['./itemstracking.component.css']
})
export class ItemsTrackingComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  employees: EmployeeDTO[];


  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.service.getAll().subscribe(employees => this.employees = employees);
  }

  
}
