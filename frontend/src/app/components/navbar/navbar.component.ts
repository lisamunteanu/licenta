import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';
import {CategoryService} from "../../service/category.service";
import {HttpResponse} from "@angular/common/http";
import {Category} from "../../model/category.model";
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product.model";
import {NotificationService} from "../../service/notification.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  universeCategories?: Category[];

  @ViewChild('searchKeyWord') searchKeyWord: ElementRef;

  constructor(public authService: AuthService, private router: Router, protected categoryService: CategoryService,
              protected productService: ProductService, protected notifyService: NotificationService) {
  }

  ngOnInit(): void {
    this.loadAllUniverseCategories();
  }

  loadAllUniverseCategories(): void {
    this.categoryService.findAllUniverseCategories().subscribe((res: HttpResponse<Category[]>) => {
      this.universeCategories = res.body ? res.body : [];
    });
  }

  redirectToMyAccount() {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/my-account']);
    }
    else {
      this.router.navigate(['/login']);
    }
  }

  redirectToMyCart() {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/my-cart']);
    }
    else {
      this.router.navigate(['/login']);
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
    this.showToasterInfo('Ati fost deconectat!');
  }

  goToProductsPage(categoryId: number) {
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([`/product/` + categoryId]);
    });
  }

  searchFor(event: Event) {
    const keyword: string = this.searchKeyWord.nativeElement.value;
    const emptyCategory = -1;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([`/product/` + emptyCategory], {queryParams: {searchKeyword: keyword}});
    });
    this.searchKeyWord.nativeElement.value = '';
    event.preventDefault();
  }

  showToasterInfo(message: string){
    this.notifyService.showInfo(message, '');
  }

}
