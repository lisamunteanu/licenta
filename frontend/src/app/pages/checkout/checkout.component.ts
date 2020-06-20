import {Component, OnInit} from '@angular/core';
import {CartEntry} from "../../model/cartEntry.model";
import {CartService} from "../../service/cart.service";
import {HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order.model";
import {ProductService} from "../../service/product.service";

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
  deliveryMode?: string;
  paymentMode?: string;
  quantity?: number;

  constructor(protected cartService: CartService, private router: Router, protected orderService: OrderService,
              protected productService: ProductService) {
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
    this.quantity = 1;
    this.productsTotal = 0;
    this.discount = 0;
    this.deliveryCost = 0;
    this.orderTotal = 0;
  }

  updatePaymentMode(typeOfPayment: string) {
    this.paymentMode = typeOfPayment;
  }

  updateDeliveryCost(event: Event, typeOfDelivery: string) {
    if (typeOfDelivery === 'home-delivery') {
      this.deliveryCost = 20.0;
    }
    else {
      this.deliveryCost = 5.0;
    }
    this.deliveryMode = typeOfDelivery;
    this.calculateTotals();
  }

  calculateTotals() {
    let i;
    this.productsTotal = this.discount = this.orderTotal = 0;
    for (i = 0; i < this.cartEntries.length; i++) {
      this.productsTotal = this.productsTotal + this.cartEntries[i].priceWithVAT;
      this.discount = this.discount + this.cartEntries[i].discount;
    }
    this.productsTotal = this.productsTotal + this.discount;
    this.orderTotal = this.productsTotal + this.deliveryCost - this.discount;
  }

  placeOrder() {
    const customerId: string = localStorage.getItem('customer_id');
    this.orderService.placeOrder(this.cartEntries, customerId, this.deliveryMode, this.paymentMode, this.quantity)
      .subscribe(data => {
        console.log(this.cartEntries);
        const resultedOrder: Order = data.body;
        console.log(resultedOrder);
        this.router.navigate(['/order-confirmation', resultedOrder.id]);
        for (const cartEntry of this.cartEntries) {
          console.log(cartEntry.quantity.toString());
          this.productService.updateStock(cartEntry.quantity.toString(), cartEntry.productId).subscribe(data2 => {
            console.log(data2.body);
          });
        }
      },
      error => {
        console.log(error);
      });
  }

}
