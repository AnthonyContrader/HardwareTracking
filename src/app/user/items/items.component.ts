import { Component, OnInit } from '@angular/core';
import { ItemDTO } from 'src/dto/itemdto';
import { ItemService } from 'src/service/item.service';

@Component({
  selector: 'app-items',
  templateUrl: './itemsToRequest.component.html',
  styleUrls: ['./itemsToRequest.component.css']
})
export class ItemsComponent implements OnInit {

  items: ItemDTO[];
  itemtoinsert: ItemDTO = new ItemDTO();

  constructor(private service: ItemService) { }

  ngOnInit() {
    this.getItems();
  }

  getItems() {
    this.service.getAll().subscribe(items => this.items = items);
  }

  
}
