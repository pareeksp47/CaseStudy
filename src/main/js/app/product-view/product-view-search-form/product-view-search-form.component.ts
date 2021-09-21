import { Component, Input, EventEmitter, Output } from '@angular/core';
import { Product } from '../../product';

@Component({
  selector: 'app-data-view-search-form',
  templateUrl: './product-view-search-form.component.html',
  styleUrls: ['./product-view-search-form.component.sass']
})
export class ProductViewSearchFormComponent {

  @Input() product: Product;

  @Output() price: EventEmitter<any> = new EventEmitter();
  @Output() rate: EventEmitter<any> = new EventEmitter();

  hasPrice: boolean;
  hasExchangeRate: boolean;
  constructor() {}

  ngOnInit(): void {
   	this.hasPrice = false;
	this.hasExchangeRate = false;
  }

  public calculatePrice(product: Product): void {
    
	this.hasPrice = true;
	this.price.next({ product: this.product });
  }

  public exchangeRate(value: number): void {
	
	this.product.value = value;
	this.rate.next({ product: this.product });
	
	this.hasExchangeRate = true;
  }

}
