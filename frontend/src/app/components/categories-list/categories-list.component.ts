import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../../model/product.model";

@Component({
  selector: 'app-categories-list',
  templateUrl: './categories-list.component.html',
  styleUrls: ['./categories-list.component.css']
})
export class CategoriesListComponent implements OnInit {
  @Input() categoryImage: string;
  @Input() categoryId: string;

  constructor() { }

  ngOnInit(): void {
  }

}
