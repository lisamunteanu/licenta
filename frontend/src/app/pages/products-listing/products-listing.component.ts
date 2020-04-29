import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product.model';
import {ProductService} from '../../service/product.service';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-products-listing',
  templateUrl: './products-listing.component.html',
  styleUrls: ['./products-listing.component.css']
})
export class ProductsListingComponent implements OnInit {
  allProducts?: Product[];

  constructor(
    protected productService: ProductService
  ) {
  }

  loadAllProducts(): void {
    this.productService.query().subscribe((res: HttpResponse<Product[]>) => {
      this.allProducts = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAllProducts();
  }

}
