import { Component, Input, OnInit, EventEmitter, Output } from '@angular/core';
import { Product } from '../../product';

@Component({
  selector: 'app-data-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.sass']
})
export class ProductListComponent {

  @Input() products: Product[];

  @Output() update: EventEmitter<any> = new EventEmitter();

  constructor() { }

	handleClick(product: Product): void {
	this.update.next({ product: product });
  }


}