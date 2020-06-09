import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent implements OnInit {
  categories;
  orderId?: number;

  constructor(protected activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.orderId = Number(params.get('id'));
    });
    this.categories = [['bannerCategorie1.png', 3], ['bannerCategorie2.png', 4],
      ['bannerCategorie3.png', 5], ['bannerCategorie4.png', 6],
      ['bannerCategorie5.png', 7], ['bannerCategorie6.png', 8]];
  }

}
