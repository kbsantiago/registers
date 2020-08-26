import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  username: string;
  password: string;
  message: any;

  constructor(private httpClientService:HttpClientService, private router:Router) { }

  ngOnInit() {
  }

  login() {
      this.httpClientService.login(this.username, this.password)
      .subscribe(data => {
        this.message = data;
        this.router.navigate(["/person"])
      });
  }

}
