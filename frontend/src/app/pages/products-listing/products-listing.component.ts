import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product.model';
import {ProductService} from '../../service/product.service';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRoute, Router} from "@angular/router";
import {Category} from "../../model/category.model";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-products-listing',
  templateUrl: './products-listing.component.html',
  styleUrls: ['./products-listing.component.css']
})
export class ProductsListingComponent implements OnInit {
  allProducts?: Product[];
  categoryId?: number;
  category?: Category;
  searchKeyword?: string;

  constructor(
    protected productService: ProductService, protected activatedRoute: ActivatedRoute, private router: Router,
    protected categoryService: CategoryService
  ) {
  }

  loadAllProductsByCategory(categoryId: number): void {
    this.productService.findAllByCategory(categoryId).subscribe((res: HttpResponse<Product[]>) => {
      this.allProducts = res.body ? res.body : [];
      if (this.allProducts.length === 0) {
        this.router.navigate(['/']);
      }
    });
  }

  findCategoryById(categoryId: number): void {
    this.categoryService.find(categoryId).subscribe((res: HttpResponse<Category>) => {
      this.category = res.body ? res.body : null;
    });
  }

  loadAllProductsFound(searchKeyword: string): void {
    this.productService.searchByKeyword(searchKeyword).subscribe((res: HttpResponse<Product[]>) => {
      this.allProducts = res.body ? res.body : [];
      if (this.allProducts.length === 0) {
        this.router.navigate(['/no-results-found']);
      }
    });
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.categoryId = Number(params.get('id'));
    });
    if (this.categoryId === -1) {
      this.activatedRoute.queryParams.subscribe(params => this.searchKeyword = params.searchKeyword);
      this.loadAllProductsFound(this.searchKeyword);
    }
    else {
      console.log(this.categoryId);
      this.findCategoryById(this.categoryId);
      this.loadAllProductsByCategory(this.categoryId);
    }
  }

}
