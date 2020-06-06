import {Component, OnInit} from '@angular/core';
import {CartEntry} from "../../model/cartEntry.model";
import {CartService} from "../../service/cart.service";
import {HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  cartEntries?: CartEntry[];
  productsTotal?: number;
  discount?: number;
  deliveryCost?: number;
  orderTotal?: number;

  constructor(protected cartService: CartService, private router: Router) {
  }

  ngOnInit(): void {
    this.initializePriceVariables();
    if (localStorage.getItem('customer_id') != null) {
      const customerId: string = localStorage.getItem('customer_id');
      this.cartService.getCartEntriesByUserId(customerId).subscribe((res: HttpResponse<CartEntry[]>) => {
        this.cartEntries = res.body ? res.body : [];
        this.calculateTotals();
      });
    }
  }

  initializePriceVariables() {
    this.productsTotal = 0;
    this.discount = 0;
    this.deliveryCost = 0;
    this.orderTotal = 0;
  }

  updateDeliveryCost(event: Event, typeOfDelivery: string) {
    if (typeOfDelivery === 'home-delivery') {
      this.deliveryCost = 20.0;
    }
    else {
      this.deliveryCost = 5.0;
    }
    this.calculateTotals();
  }

  calculateTotals() {
    let i;
    for (i = 0; i < this.cartEntries.length; i++) {
      this.productsTotal = this.productsTotal + this.cartEntries[i].priceWithVAT;
      this.discount = this.discount + this.cartEntries[i].discount;
    }
    this.orderTotal = this.productsTotal + this.deliveryCost;
  }

  placeOrder() {
    this.router.navigate(['/order-confirmation']);
  }

}
