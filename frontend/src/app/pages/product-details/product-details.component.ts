import {AfterViewInit, Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
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
    this.hideTabContent(1);
  }

  populateCartEntry(cartEntry: CartEntry): void {
    cartEntry.productName = this.product.name;
    cartEntry.productDescription = this.product.description;
    cartEntry.productImage = this.product.image;
    cartEntry.productBrand = this.product.brand;
    cartEntry.productId = this.product.id;
    cartEntry.quantity = 1;
    cartEntry.priceWithVAT = this.product.price.finalPrice;
    cartEntry.priceWithoutVAT = this.product.price.priceWithoutVAT;
    cartEntry.discount = this.product.price.discount;
    cartEntry.productPriceVAT = this.product.price.vat;
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

  hideTabContent(contor: number) {
    let i;
    let tabcontent;
    tabcontent = document.getElementsByClassName('tabcontent');
    for (i = contor; i < tabcontent.length; i++) {
      tabcontent[i].style.display = 'none';
    }
  }

  openTab(event: Event, tabName: string) {
    let tablinks;
    let i;
    this.hideTabContent(0);
    tablinks = document.getElementsByClassName('tablinks');
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(' active', '');
    }

    document.getElementById(tabName).style.display = 'block';
    const targetElem = event.currentTarget as HTMLElement;
    targetElem.className += ' active';
  }


}
