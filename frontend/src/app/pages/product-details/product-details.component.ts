import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../model/product.model';
import {ProductService} from '../../service/product.service';
import {HttpParams, HttpResponse} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
import {CartService} from "../../service/cart.service";
import {CartEntry} from "../../model/cartEntry.model";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product?: Product;
  productId?: number;

  constructor(
    protected productService: ProductService, protected activatedRoute: ActivatedRoute,
    protected cartService: CartService
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

  populateCartEntry(cartEntry: CartEntry): void {
    cartEntry.productName = this.product.name;
    cartEntry.productDescription = this.product.description;
    cartEntry.productImage = this.product.image;
    cartEntry.productBrand = this.product.brand;
    cartEntry.productId = this.product.id;
    cartEntry.quantity = 1;
  }

  addToCart() {
    const cartEntry: CartEntry = new CartEntry();
    this.populateCartEntry(cartEntry);
    const userId: string = localStorage.getItem('customer_id');
    this.cartService.addToCart(cartEntry, userId).subscribe(data => {
        const resultedCartEntry: CartEntry = data.body;
        console.log(resultedCartEntry);
      },
      error => {
        console.log(error);
      });

  }

}
