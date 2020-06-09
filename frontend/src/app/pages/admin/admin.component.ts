import {Component, OnInit} from '@angular/core';
import {Order} from '../../model/order.model';
import {Customer} from '../../model/customer.model';
import {Router} from '@angular/router';
import {OrderService} from '../../service/order.service';
import {CustomerService} from '../../service/customer.service';
import {HttpResponse} from '@angular/common/http';
import {ExportService} from "../../service/export.service";
import {NotificationService} from "../../service/notification.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  allOrders?: Order[];
  allCustomers?: Customer[];

  constructor(private router: Router, protected orderService: OrderService, protected customerService: CustomerService,
              protected exportService: ExportService, protected notifyService: NotificationService) {
  }

  ngOnInit(): void {
    this.hideTabContent(1);
    this.loadOrders();
    this.loadCustomers();
  }

  loadOrders() {
    this.orderService.getAllOrders().subscribe((res: HttpResponse<Order[]>) => {
      this.allOrders = res.body ? res.body : [];
    });
  }

  loadCustomers() {
    this.customerService.getAllCustomers().subscribe((res: HttpResponse<Customer[]>) => {
      this.allCustomers = res.body ? res.body : [];
    });
  }

  hideTabContent(contor: number) {
    let tabcontent;
    let i;
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName('tabcontent');
    for (i = contor; i < tabcontent.length; i++) {
      tabcontent[i].style.display = 'none';
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

  exportOrdersToCSV() {
    this.exportService.exportOrders().subscribe((response) => {
      console.log(response.body);
      if (response.body === 'OK') {
        this.showToasterInfo('Comenzile din ultimele 24 de ore au fost exportate catre fisierul CSV cu succes!');
      }
      else{
        this.showToasterError('S-a produs o eroare la exportarea comenzilor catre fisierul CSV.');
      }
    });
  }

  exportOrderEntriesToCSV() {
    this.exportService.exportOrderEntries().subscribe((response) => {
      console.log(response.body);
      if (response.body === 'OK') {
        this.showToasterInfo('Intrarile de comenda din ultimele 24 de ore au fost exportate catre fisierul CSV cu succes!');
      }
      else{
        this.showToasterError('S-a produs o eroare la exportarea intrarilor de comanda catre fisierul CSV.');
      }
    });
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
