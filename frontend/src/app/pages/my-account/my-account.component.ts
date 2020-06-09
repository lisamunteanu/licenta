import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../../model/customer.model';
import {CustomerService} from '../../service/customer.service';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';
import {NotificationService} from "../../service/notification.service";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order.model";
import {HttpResponse} from "@angular/common/http";
import {Product} from "../../model/product.model";
import {Address} from "../../model/address.model";
import {AddressService} from "../../service/address.service";

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {
  public customer?: Customer;
  public orders?: Order[];
  public addresses?: Address[];

  constructor(protected customerService: CustomerService, protected authService: AuthService, private router: Router,
              protected notifyService: NotificationService, protected orderService: OrderService,
              protected addressService: AddressService) {
  }

  ngOnInit(): void {
    const id: string = localStorage.getItem('customer_id');
    if (id != null) {
      this.customerService.findById(id).subscribe((res) => this.customer = res.body ? res.body : null);
      this.orderService.getOrdersByCustomerId(id).subscribe((res: HttpResponse<Order[]>) => {
        this.orders = res.body ? res.body : [];
      });
      this.addressService.getAllAddressesByCustomerId(id).subscribe((res: HttpResponse<Address[]>)=>
      {
        this.addresses = res.body ? res.body : [];
      });
    }
    this.hideTabContents(1);
  }

  logOut() {
    this.authService.logout();
    this.router.navigate(['/']);
    this.showToasterInfo('Ati fost deconectat!');
  }

  hideTabContents(contor: number) {
    let tabcontent;
    let i;
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName('tabcontent');
    for (i = contor; i < tabcontent.length; i++) {
      tabcontent[i].style.display = 'none';
    }
  }

  openTab(evt: Event, cityName: string) {
    // Declare all variables
    let i;
    let tablinks;

    // Get all elements with class="tabcontent" and hide them
    this.hideTabContents(0);

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName('tablinks');
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(' active', '');
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(cityName).style.display = 'block';
    const targetElem = evt.currentTarget as HTMLElement;
    targetElem.className += ' active';
  }

  showToasterInfo(message: string) {
    this.notifyService.showInfo(message, '');
  }

}
