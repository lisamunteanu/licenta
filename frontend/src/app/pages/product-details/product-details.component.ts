import {AfterViewInit, Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Product} from '../../model/product.model';
import {ProductService} from '../../service/product.service';
import {HttpParams, HttpResponse} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {CartService} from "../../service/cart.service";
import {CartEntry} from "../../model/cartEntry.model";
import {NotificationService} from "../../service/notification.service";

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
    protected cartService: CartService, private notifyService: NotificationService, private router: Router
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
    if (this.isNotLoggedIn()) {
      this.router.navigate(['/login']);
      this.showToasterInfo('Pentru a adauga produse in cos, te rugam sa te autentifici.');
    }
    else {
      this.cartService.addToCart(cartEntry, userId).subscribe(data => {
          const resultedCartEntry: CartEntry = data.body;
          this.showToasterSuccess('Produsul ' + resultedCartEntry.productName + ' a fos adaugat cu succes in cos!');
        },
        error => {
          this.showToasterError('A aparut o eroare la adaugarea produsului in cos!');
        });
    }
  }

  hideTabContent(contor: number) {
    let i;
    let tabcontent;
    tabcontent = document.getElementsByClassName('tabcontent');
    for (i = contor; i < tabcontent.length; i++) {
      tabcontent[i].style.display = 'none';
    }
  }

  isNotLoggedIn() {
    const customerId: string = localStorage.getItem('customer_id');
    if (customerId == null || customerId === undefined) {
      return true;
    }
    else {
      return false;
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

  showToasterSuccess(message: string) {
    this.notifyService.showSuccess(message, '');
  }

  showToasterError(message: string) {
    this.notifyService.showError(message, '');
  }

  showToasterInfo(message: string) {
    this.notifyService.showInfo(message, '');
  }


}
