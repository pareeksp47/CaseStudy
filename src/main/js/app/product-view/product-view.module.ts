import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { FlexLayoutModule } from '@angular/flex-layout';

import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';

import { ProductListComponent } from './product-list/product-list.component';
import { ProductViewSearchComponent } from './product-view-search/product-view-search.component';
import { ProductViewSearchFormComponent } from './product-view-search-form/product-view-search-form.component';

@NgModule({
  declarations: [
    ProductListComponent,
    ProductViewSearchComponent,
    ProductViewSearchFormComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FlexLayoutModule,
    MatButtonModule,
    MatInputModule,
    MatListModule
  ],
  exports: [
    CommonModule,
    RouterModule,
    FlexLayoutModule,
    MatButtonModule,
    MatInputModule,
    MatListModule,
    ProductListComponent
  ]
})
export class ProductViewModule { }
