import { Component, OnInit } from '@angular/core';
import { ItemLentService } from 'src/service/itemlent.service';
import { ItemLentDTO } from 'src/dto/itemlentdto';

@Component({
  selector: 'app-itemstracking',
  templateUrl: './itemstracking.component.html',
  styleUrls: ['./itemstracking.component.css']
})
export class ItemsTrackingComponent implements OnInit {

  itemslent: ItemLentDTO[];
  itemlenttoinsert: ItemLentDTO = new ItemLentDTO();

  constructor(private service: ItemLentService) { }

  ngOnInit() {
    this.getItemsTracking();
  }

  getItemsTracking() {
    this.service.getAll().subscribe(itemslent => this.itemslent = itemslent);
  }

  delete(itemlent: ItemLentDTO) {
    this.service.delete(itemlent.id).subscribe(() => this.getItemsTracking());
  }

  update(itemlent: ItemLentDTO) {
    this.service.update(itemlent).subscribe(() => this.getItemsTracking());
  }

  insert(itemlent: ItemLentDTO) {
    this.service.insert(itemlent).subscribe(() => this.getItemsTracking());
  }

  clear(){
    this.itemlenttoinsert = new ItemLentDTO();
  }
}
