import { Component, OnInit } from '@angular/core';
import {HttpClientService, Person} from "../../service/http-client.service";
import { ActivatedRoute, Router} from "@angular/router";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-edit-person',
  templateUrl: './edit-person.component.html',
  styleUrls: ['./edit-person.component.css']
})
export class EditPersonComponent implements OnInit {

  id: number;
  person: Person;

  constructor(private httpClientService: HttpClientService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.person = new Person("", "","","","","","","");
    this.id = this.route.snapshot.params['id'];

    this.httpClientService.getPerson(this.id)
      .subscribe(data => {
        this.person = data;
        this.person.birthDate = new DatePipe('en-US').transform(this.person.birthDate, 'dd/MM/yyyy')
      }, error => console.log(error));
  }

  backToList(): void {
    this.router.navigate(["/person"]);
  }

  updatePerson(): void {
    this.httpClientService.updatePerson(this.person)
      .subscribe( data => {
        alert("Person updated successfully.");
        this.backToList();
      });
  };

  onSubmit() {
    console.log(this.person);
    this.updatePerson();
  }

}
