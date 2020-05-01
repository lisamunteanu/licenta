import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  customer?: Customer;
  registerForm: FormGroup;
  submitted = false;
  returnUrl: string;

  constructor(protected customerService: CustomerService, private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router) {
  }

  get f() {
    return this.registerForm.controls;
  }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      confirm: ['', Validators.required]
    });

    this.returnUrl = '/login';
    this.customer = new Customer();
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    this.customer.name = this.f.name.value;
    this.customer.username = this.f.email.value;
    this.customer.password = this.f.password.value;

    if (this.customer.password === this.f.confirm.value) {
      this.customerService.register(this.customer).subscribe(data => {
          this.router.navigate([this.returnUrl]);
        },
        error => {
          console.log('bad request ' + error);
        });
    }
    else {
      console.log('password and confirm password not matching');
    }

  }
}


