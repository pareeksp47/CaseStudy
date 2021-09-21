import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductViewSearchComponent } from './product-view/product-view-search/product-view-search.component';

const routes: Routes = [
  { path: '', redirectTo: '/product', pathMatch: 'full' },
  { path: 'product', component: ProductViewSearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
