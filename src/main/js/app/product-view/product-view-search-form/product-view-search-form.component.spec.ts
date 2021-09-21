import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpClientModule } from '@angular/common/http';

import { ProductViewSearchFormComponent } from './product-view-search-form.component';

describe('ProductViewSearchFormComponent', () => {
  let component: ProductViewSearchFormComponent;
  let fixture: ComponentFixture<ProductViewSearchFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
      declarations: [ ProductViewSearchFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductViewSearchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
