import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Credentials} from "../../model/credentials.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {NotificationService} from "../../service/notification.service";
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials?: Credentials;

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(protected authService: AuthService, private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router, protected notifyService: NotificationService, private customerService: CustomerService) {
  }

  showToasterInfo(message: string) {
    this.notifyService.showInfo(message, '')
  }

  get f() {
    return this.loginForm.controls;
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.returnUrl = '/';
    this.credentials = new Credentials();
  }

  login(): void {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    this.loading = true;
    this.credentials.username = this.f.username.value;
    this.credentials.password = this.f.password.value;

    this.authService.authenticate(this.credentials).subscribe(data => {
        this.authService.saveCustomerId(this.credentials);
        let customer: Customer;
        this.customerService.findByUsername(this.credentials.username).subscribe((response) => {
          customer = response.body;
          if (customer.role === 'USER') {
            this.router.navigate([this.returnUrl]);
          }
          else if (customer.role === 'ADMIN') {
            this.router.navigate(['/admin']);
          }
          this.showToasterInfo('Autentificarea s-a facut cu succes!');
        });
      },
      error => {
        this.loading = false;
        this.showToasterError('A intervenit o eroare in procesul de autentificare.');
      });
  }

  showToasterError(message: string) {
    this.notifyService.showError(message, '');
  }

}
