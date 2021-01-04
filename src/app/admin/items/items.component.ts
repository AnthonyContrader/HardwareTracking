import { Component, OnInit } from '@angular/core';
import { ItemDTO } from 'src/dto/itemdto';
import { ItemService } from 'src/service/item.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
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

  delete(item: ItemDTO) {
    if(confirm("Are you sure?"))
    this.service.delete(item.id).subscribe(() => this.getItems());
  }

  update(item: ItemDTO) {
    this.service.update(item).subscribe(() => this.getItems());
  }

  insert(item: ItemDTO) {
    this.service.insert(item).subscribe(() => this.getItems());
  }

  clear(){
    this.itemtoinsert = new ItemDTO();
  }
}
