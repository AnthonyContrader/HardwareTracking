import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemDTO } from 'src/dto/itemdto';
import { ItemLentDTO } from 'src/dto/itemlentdto';
import { UserDTO } from 'src/dto/userdto';
import { ItemService } from 'src/service/item.service';
import { ItemLentService } from 'src/service/itemlent.service';

@Component({
  selector: 'app-itemsToReturn',
  templateUrl: './itemsToReturn.component.html',
  styleUrls: ['./itemsToReturn.component.css']
})
export class ItemsToReturnComponent implements OnInit {

  user: UserDTO;
  items: ItemLentDTO[];
  
  constructor(private service: ItemLentService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getMyRequests(this.user.employee.fiscalCode);
  }

  getMyRequests(fiscalCode: string) {
    this.service.getMyRequests(fiscalCode).subscribe(items => this.items = items);
  }

  return(info: string){
    this.service.return(info).subscribe(() => this.getMyRequests(this.user.employee.fiscalCode));
  }
  
}
