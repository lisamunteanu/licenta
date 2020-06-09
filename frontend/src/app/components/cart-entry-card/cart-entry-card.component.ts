import {Component, Input, OnInit} from '@angular/core';
import {CartEntry} from '../../model/cartEntry.model';
import {CartService} from '../../service/cart.service';
import {Router} from '@angular/router';
import {NotificationService} from "../../service/notification.service";

@Component({
  selector: 'app-cart-entry-card',
  templateUrl: './cart-entry-card.component.html',
  styleUrls: ['./cart-entry-card.component.css']
})
export class CartEntryCardComponent implements OnInit {
  @Input() cartEntry: CartEntry;

  constructor(protected cartService: CartService, private router: Router, protected notifyService: NotificationService) {
  }

  ngOnInit(): void {
  }

  removeFromCart() {
    const userId: string = localStorage.getItem('customer_id');
    this.cartService.removeOrUpdateCart(this.cartEntry.id.toString(), userId).subscribe(data => {
        window.location.reload();
        this.showToasterSuccess('Produsul a fost sters cu succes din cos!');
      },
      error => {
        this.showToasterError('A aparut o eroare la stergerea produsului din cos!');
      }
    );
  }

  showToasterSuccess(message: string) {
    this.notifyService.showSuccess(message, '');
  }

  showToasterError(message: string) {
    this.notifyService.showError(message, '');
  }

}
