import { Component, OnInit } from '@angular/core';
import { HttpClientService, Person } from '../service/http-client.service';
import { Router } from '@angular/router';
import {Observable} from "rxjs";

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  people: Observable<Person[]>;

  constructor(private httpClientService:HttpClientService, private router:Router) { }

  ngOnInit() {
    this.reloadData();
  }

  handleSuccessfulResponse(response)
  {
    this.people=response;
  }

  reloadData() {
    this.httpClientService.getPeople().subscribe(
      response =>this.handleSuccessfulResponse(response),
    );
  }

  addPerson() {
    this.router.navigate(["/addperson"])
  }

  updatePerson(id: number) {
    this.router.navigate(["/editperson", id])
  }

  deletePerson(id:bigint): void {
    this.httpClientService.deletePerson(id)
      .subscribe(  data => {
          alert("Person deleted successfully.");
          this.reloadData();
        },
        error => console.log(error));
  };
}
