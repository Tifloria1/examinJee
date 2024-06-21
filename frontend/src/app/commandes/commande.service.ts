import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Commande } from './commande.model';
import { LigneCMD } from '../ligne-cmd/ligne-cmd.model';


@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private apiUrl = 'http://localhost:8080/api/commandes';

  constructor(private http: HttpClient) {}

  getCommandes(): Observable<Commande[]> {
    return this.http.get<Commande[]>(this.apiUrl);
  }

  addCommande(commande: Commande): Observable<Commande> {
    return this.http.post<Commande>(this.apiUrl, commande);
  }

  updateCommande(commande: Commande): Observable<Commande> {
    return this.http.put<Commande>(`${this.apiUrl}/${commande.idCmd}`, commande);
  }

  deleteCommande(idCmd: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${idCmd}`);
  }

  getLignesCmd(commandeId: number): Observable<LigneCMD[]> {
    return this.http.get<LigneCMD[]>(`${this.apiUrl}/${commandeId}/lignes`);
  }

  addLigneCmd(commandeId: number, ligneCmd: LigneCMD): Observable<LigneCMD> {
    return this.http.post<LigneCMD>(`${this.apiUrl}/${commandeId}/lignes`, ligneCmd);
  }

  deleteLigneCmd(commandeId: number, ligneCmdId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${commandeId}/lignes/${ligneCmdId}`);
  }
}
