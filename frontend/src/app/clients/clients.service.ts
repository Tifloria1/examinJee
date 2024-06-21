import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from './client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {
//declariw chaine de caractere 
  backEndUrl ="http://localhost:8080/api/clients";


  constructor(private http: HttpClient) { 
    //2.httpclient bch ijiblina donees , khasna n injictiwh
    //kan anjiktiw wst constructor 

  }
  
  getAllClients():Observable<Client[]> {  //1anytype deretour
    return this.http.get<Client[]>(this.backEndUrl);

    
  }
  searchClients(term: string): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.backEndUrl}/search?term=${term}`);
  }
  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.backEndUrl, client);
  }

  updateClient(idClient: number, client: Client): Observable<Client> {
    return this.http.put<Client>(`${this.backEndUrl}/${idClient}`, client);
  }

  deleteClient(idClient: number): Observable<void> {
    return this.http.delete<void>(`${this.backEndUrl}/${idClient}`);

}

}