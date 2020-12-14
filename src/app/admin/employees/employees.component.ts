import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/service/employee.service';
import { EmployeeDTO } from 'src/dto/employeedto';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  employees: EmployeeDTO[];
  employeetoinsert: EmployeeDTO = new EmployeeDTO();

  constructor(private service: EmployeeService) { }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.service.getAll().subscribe(employees => this.employees = employees);
  }

  delete(employee: EmployeeDTO) {
    this.service.delete(employee.id).subscribe(() => this.getEmployees());
  }

  update(employee: EmployeeDTO) {
    this.service.update(employee).subscribe(() => this.getEmployees());
  }

  insert(employee: EmployeeDTO) {
    this.service.insert(employee).subscribe(() => this.getEmployees());
  }

  clear(){
    this.employeetoinsert = new EmployeeDTO();
  }
}
