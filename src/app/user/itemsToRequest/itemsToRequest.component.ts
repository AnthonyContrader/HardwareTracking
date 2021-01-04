import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemDTO } from 'src/dto/itemdto';
import { ItemLentDTO } from 'src/dto/itemlentdto';
import { UserDTO } from 'src/dto/userdto';
import { ItemService } from 'src/service/item.service';
import { ItemLentService } from 'src/service/itemlent.service';

@Component({
  selector: 'app-itemsToRequest',
  templateUrl: './itemsToRequest.component.html',
  styleUrls: ['./itemsToRequest.component.css']
})
export class ItemsToRequestComponent implements OnInit {

  user: UserDTO;
  items: ItemDTO[];
  itemtorequest: ItemLentDTO = new ItemLentDTO();

  constructor(private service: ItemService, private itemLentService: ItemLentService) { }

  ngOnInit() {
    this.getItems();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getItems() {
    this.service.getAll().subscribe(items => this.items = items);
  }

  request(dto: ItemLentDTO){
    this.itemLentService.request(dto).subscribe(() => this.getItems);
  }

  createRequest(firstName: string, lastName: string, 
                itemName: string, fiscalCodeForLent: string){
                  this.itemtorequest.firstNameOwner = firstName;
                  this.itemtorequest.lastNameOwner = lastName;
                  this.itemtorequest.fiscalCodeForLent = fiscalCodeForLent;
                  this.itemtorequest.itemName = itemName;

            this.request(this.itemtorequest);
                }
}
