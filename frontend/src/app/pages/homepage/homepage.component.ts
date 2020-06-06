import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  categories;
  constructor() {
  }

  ngOnInit(): void {
    this.categories = [['bannerCategorie1.png', 3], ['bannerCategorie2.png', 4],
      ['bannerCategorie3.png', 5], ['bannerCategorie4.png', 6],
      ['bannerCategorie5.png', 7], ['bannerCategorie6.png', 8]];
  }

}
