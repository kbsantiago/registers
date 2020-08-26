import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

export class Person{
  constructor(
    public id:string,
    public name:string,
    public sex:string,
    public email:string,
    public birthDate: string,
    public birthPlace:string,
    public nationality:string,
    public document:string
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  base_url = "http://localhost:8080/api";
  constructor(private httpClient:HttpClient) { }

  login(username:string, password:string) {
    const headers = new HttpHeaders({Authorization: 'Basic' + btoa(username+':'+password)})
    return this.httpClient.post(this.base_url + '/v1/auth/login', {headers, responseType:'text' as 'json'});
  }

  getPeople(): Observable<any>
  {
    return this.httpClient.get<Person[]>(this.base_url + '/v1/registers/person?page=0');
  }

  getPerson(id:number): Observable<any>{
    return this.httpClient.get(this.base_url + '/v1/registers/person/' + id);
  }

  savePerson(person:Object): Observable<any> {
    return this.httpClient.post(this.base_url + '/v1/registers/person', person);
  }

  updatePerson(person:Object): Observable<any> {
    return this.httpClient.put(this.base_url + '/v1/registers/person', person);
  }

  deletePerson(id:bigint): Observable<any>{
    return this.httpClient.delete(this.base_url + '/v1/registers/person/' + id);
  }
}
