import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemDTO } from 'src/dto/itemdto';
import { UserDTO } from 'src/dto/userdto';
import { EmployeeService } from 'src/service/employee.service';
import { ItemService } from 'src/service/item.service';

@Component({
  selector: 'app-itemsToRequest',
  templateUrl: './itemsToRequest.component.html',
  styleUrls: ['./itemsToRequest.component.css']
})
export class ItemsToRequestComponent implements OnInit {

  user: UserDTO;
  items: ItemDTO[];
  itemtoinsert: ItemDTO = new ItemDTO();

  constructor(private service: ItemService, private employeeService: EmployeeService) { }

  ngOnInit() {
    this.getItems();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getItems() {
    this.service.getAll().subscribe(items => this.items = items);
  }

  request(info: string){
    this.employeeService.request(info).subscribe(() => this.getItems);
  }

  

}
