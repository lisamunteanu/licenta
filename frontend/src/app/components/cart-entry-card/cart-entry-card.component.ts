import {Component, Input, OnInit} from '@angular/core';
import {CartEntry} from '../../model/cartEntry.model';
import {CartService} from '../../service/cart.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cart-entry-card',
  templateUrl: './cart-entry-card.component.html',
  styleUrls: ['./cart-entry-card.component.css']
})
export class CartEntryCardComponent implements OnInit {
  @Input() cartEntry: CartEntry;

  constructor(protected cartService: CartService, private router: Router) {
  }

  ngOnInit(): void {
  }

  removeFromCart() {
    const userId: string = localStorage.getItem('customer_id');
    this.cartService.removeOrUpdateCart(this.cartEntry.id.toString(), userId).subscribe(data => {
        console.log(data);
        window.location.reload();
      },
      error => {
        console.log(error);
      }
    );
  }

}
