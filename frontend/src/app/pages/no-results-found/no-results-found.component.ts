import {Component, OnInit} from '@angular/core';
import {Category} from "../../model/category.model";
import {CategoryService} from "../../service/category.service";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-no-results-found',
  templateUrl: './no-results-found.component.html',
  styleUrls: ['./no-results-found.component.css']
})
export class NoResultsFoundComponent implements OnInit {
  allCategories?: Category[];
  categories;

  constructor(protected categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.loadAllCategories();
    this.categories = [['bannerCategorie1.png', 3], ['bannerCategorie2.png', 4],
      ['bannerCategorie3.png', 5], ['bannerCategorie4.png', 6],
      ['bannerCategorie5.png', 7], ['bannerCategorie6.png', 8]];
  }

  loadAllCategories() {
    this.categoryService.findAllUniverseCategories().subscribe((res: HttpResponse<Category[]>) => {
      this.allCategories = res.body ? res.body : [];
    });
  }

}
