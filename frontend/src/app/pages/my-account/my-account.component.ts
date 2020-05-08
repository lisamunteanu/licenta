import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../../model/customer.model';
import {CustomerService} from '../../service/customer.service';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {
  public customer?: Customer;

  constructor(protected customerService: CustomerService, protected authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
    const id: string = localStorage.getItem('customer_id');
    if (id != null) {
      this.customerService.findById(id).subscribe((res) => this.customer = res.body ? res.body : null);
    }
  }

  logOut() {
    this.authService.logout();
    this.router.navigate(['/']);
  }

}
