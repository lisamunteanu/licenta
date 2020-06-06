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
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required, Validators.minLength(6)],
      confirm: ['', Validators.required]
    }, {
      validator: MustMatch('password', 'confirm')
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
  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }
}

export function MustMatch(controlName: string, matchingControlName: string) {
  return (formGroup: FormGroup) => {
    const control = formGroup.controls[controlName];
    const matchingControl = formGroup.controls[matchingControlName];

    if (matchingControl.errors && !matchingControl.errors.mustMatch) {
      // return if another validator has already found an error on the matchingControl
      return;
    }

    // set error on matchingControl if validation fails
    if (control.value !== matchingControl.value) {
      matchingControl.setErrors({mustMatch: true});
    } else {
      matchingControl.setErrors(null);
    }
  };
}


