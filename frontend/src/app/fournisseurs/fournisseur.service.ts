import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from './fournisseur.model';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  backEndUrl ="http://localhost:8080/api/fournisseurs";
  fournissuers: any
  fournisseurService: any;
  fournisseurs: any;
  fournisseur: any;

  constructor(private http: HttpClient) { 

  }

  getAllFournisseurs(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>(this.backEndUrl);
  }

  getFournisseurById(id: number): Observable<Fournisseur> {
    return this.http.get<Fournisseur>(`${this.backEndUrl}/${id}`);
  }

  createFournisseur(fournisseur: Fournisseur): Observable<Fournisseur> {
        const token = localStorage.getItem('token'); 
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    return this.http.post<Fournisseur>(this.backEndUrl, fournisseur);
  }

  updateFournisseur(id: number, fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.http.put<Fournisseur>(`${this.backEndUrl}/${id}`, fournisseur);
  }

  loadFournisseurs(): void {
    this.fournisseur = this.fournisseurService.getFournisseurs();
  }
  deleteFournisseur(id: number): Observable<void> { {
    return this.fournisseurService.deleteFournisseur(id).subscribe(() => {
      this.loadFournisseurs();
    });
    

}
}
}
