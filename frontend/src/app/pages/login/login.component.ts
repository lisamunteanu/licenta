import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Credentials} from "../../model/credentials.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

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
              private router: Router) {
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
        this.router.navigate([this.returnUrl]);
      },
      error => {
        this.loading = false;
        console.log('bad credentials');
      });
  }

}
