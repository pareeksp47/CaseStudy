import { Injectable } from '@angular/core';
import { Product } from './product';
import { ApiResponse } from './api-response';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  private endpointProduct = 'http://localhost:8080/rest/product';


  constructor(
    private http: HttpClient
  ) { }

  search(query: string): Observable<Product[]> {
    const params = { query };
    return this.http.get<ApiResponse<Product[]>>(this.endpointProduct, {}).pipe(
      map((response: ApiResponse<Product[]>) => {  return response.content }),
      catchError(this.handleError<Product[]>('search', []))
    ).pipe(
      catchError(this.handleError<Product[]>('search', []))
    );
  }

  calculatePrice(product: Product): Observable<Product> {
    return this.http.put<ApiResponse<Product>>(this.endpointProduct, product).pipe(
	 map((response: ApiResponse<Product>) => {  return response.content }),
      catchError(this.handleError<Product>('calculatePrice', null))
    ).pipe(
      catchError(this.handleError<Product>('calculatePrice', null))
    );
  }

  exchangeRate(product: Product): Observable<Product> {
    return this.http.patch<ApiResponse<Product>>(this.endpointProduct, product).pipe(
	 map((response: ApiResponse<Product>) => {  return response.content }),
      catchError(this.handleError<Product>('calculatePrice', null))
    ).pipe(
      catchError(this.handleError<Product>('calculatePrice', null))
    );
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
