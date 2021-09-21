import { Component, OnInit } from '@angular/core';
import { Product } from '../../product';
import { ProductService } from '../../product.service';

@Component({
  selector: 'app-data-view-search',
  templateUrl: './product-view-search.component.html',
  styleUrls: ['./product-view-search.component.sass']
})
export class ProductViewSearchComponent implements OnInit {

  shownProducts: Product[];

   selectedProduct: Product;

  constructor(private ProductService: ProductService) { }

  ngOnInit(): void {
    this.getAllData();
  }

  getAllData(): void {
    this.ProductService.search("").subscribe(data => this.shownProducts = data);
  }

  handleSearch(query): void {
	
    this.selectedProduct = query.product;
	console.log('p1='+this.selectedProduct);
  }

  calculatePrice(query): void {
	this.ProductService.calculatePrice(query.product).subscribe(data => this.selectedProduct = data);
  }

  exchangeRate(query): void {
	this.ProductService.exchangeRate(query.product).subscribe(data => this.selectedProduct = data);
 }
}