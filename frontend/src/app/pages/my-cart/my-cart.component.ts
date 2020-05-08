import {Component, OnInit} from '@angular/core';
import {CartEntry} from '../../model/cartEntry.model';
import {CartService} from '../../service/cart.service';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-my-cart',
  templateUrl: './my-cart.component.html',
  styleUrls: ['./my-cart.component.css']
})
export class MyCartComponent implements OnInit {
  cartEntries?: CartEntry[];

  constructor(protected cartService: CartService) {
  }

  ngOnInit(): void {
    if (localStorage.getItem('customer_id') != null) {
      const customerId: string = localStorage.getItem('customer_id');
      this.cartService.getCartEntriesByUserId(customerId).subscribe((res: HttpResponse<CartEntry[]>) => {
        this.cartEntries = res.body ? res.body : [];
      });
    }
  }

  goToCheckout(){

  }

}
