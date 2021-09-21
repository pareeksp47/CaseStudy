import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpClientModule } from '@angular/common/http';

import { ProductViewSearchComponent } from './product-view-search.component';

describe('ProductViewSearchComponent', () => {
  let component: ProductViewSearchComponent;
  let fixture: ComponentFixture<ProductViewSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
      declarations: [ ProductViewSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductViewSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
