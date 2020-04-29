import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../model/product.model';
import {ProductService} from '../../service/product.service';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product?: Product;
  productId?: number;

  constructor(
    protected productService: ProductService, protected activatedRoute: ActivatedRoute
  ) {
  }

  initProduct(productId?: number): void {
    this.productService.find(productId).subscribe((res: HttpResponse<Product>) => {
      this.product = res.body ? res.body : null;
    });
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.productId = Number(params.get('id'));
    });
    this.initProduct(this.productId);
  }

}
