import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;

  firstName = new FormControl("", Validators.required);

  constructor(fb: FormBuilder) {
    this.form = fb.group({
      "firstName": this.firstName,
      "password": ["", Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("model-based form submitted");
    console.log(this.form);
  }
}


