import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent implements OnInit {
  categories;

  constructor() { }

  ngOnInit(): void {
    this.categories = [['bannerCategorie1.png', 3], ['bannerCategorie2.png', 4],
      ['bannerCategorie3.png', 5], ['bannerCategorie4.png', 6],
      ['bannerCategorie5.png', 7], ['bannerCategorie6.png', 8]];
  }

}
