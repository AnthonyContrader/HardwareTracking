import { Component, OnInit } from '@angular/core';
import { ItemLentService } from 'src/service/itemlent.service';
import { ItemLentDTO } from 'src/dto/itemlentdto';
import { EmployeeService } from 'src/service/employee.service';
import { EmployeeDTO } from 'src/dto/employeedto';
import { ItemDTO } from 'src/dto/itemdto';

@Component({
  selector: 'app-itemstracking',
  templateUrl: './itemstracking.component.html',
  styleUrls: ['./itemstracking.component.css']
})
export class ItemsTrackingComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  employees: EmployeeDTO[];


  ngOnInit() {
    this.trackItems();
  }

  trackItems() {
    this.service.trackItems().subscribe(employees => this.employees = employees);
  }


  
}
