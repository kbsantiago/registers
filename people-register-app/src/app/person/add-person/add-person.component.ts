import { Component, OnInit } from '@angular/core';
import { HttpClientService, Person } from '../../service/http-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent implements OnInit {

  person: Person = new Person("","","","", "","","", "");
  submitted = false;

  constructor(private httpClientService: HttpClientService, private router:Router) { }

  ngOnInit() {
  }

  savePerson(): void {
    this.httpClientService.savePerson(this.person)
      .subscribe( data => {
        console.log("Person created successfully.")
        this.person = new Person("","","","","","","", "");
        alert("Person saved successfully.");
        this.backToList(),
            error => console.log(error);
      });
  };

  onSubmit() {
    this.submitted = true;
    this.savePerson();
  }

  backToList(): void {
    this.router.navigate(["/person"]);
  }

}
