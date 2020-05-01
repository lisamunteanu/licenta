import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(protected authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
  }

  redirectTo() {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/my-account']);
    }
    else{
      this.router.navigate(['/login']);
    }
  }

}
