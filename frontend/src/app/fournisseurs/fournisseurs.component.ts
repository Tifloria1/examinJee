import { Component, OnInit } from '@angular/core';
import { Fournisseur } from './fournisseur.model';
import { FournisseurService } from './fournisseur.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-fournisseurs',
  standalone: true,
  templateUrl: './fournisseurs.component.html',
  styleUrls: ['./fournisseurs.component.css'],
  imports: [FormsModule , CommonModule]
})
export class FournisseursComponent implements OnInit {
  fournisseurs: Fournisseur[] = [];
  selectedFournisseur: Fournisseur | null = null;
  newFournisseur: Fournisseur = { id_Four: 0, nom: '', prenom: '' };
  formNom: string = '';
  formPrenom: string = '';

  constructor(private fournisseurService: FournisseurService) {}

  ngOnInit(): void {
    this.getAllFournisseurs();
  }

  getAllFournisseurs(): void {
    this.fournisseurService.getAllFournisseurs().subscribe(data => {
      this.fournisseurs = data;
    }, error => {
      console.error('Error fetching fournisseurs', error);
    });
  }

  selectFournisseur(fournisseur: Fournisseur): void {
    this.selectedFournisseur = { ...fournisseur };
    this.formNom = fournisseur.nom;
    this.formPrenom = fournisseur.prenom;
  }

  saveFournisseur(): void {
    if (this.selectedFournisseur) {
      this.selectedFournisseur.nom = this.formNom;
      this.selectedFournisseur.prenom = this.formPrenom;
      this.fournisseurService.updateFournisseur(this.selectedFournisseur.id_Four, this.selectedFournisseur).subscribe(() => {
        this.getAllFournisseurs();
        this.selectedFournisseur = null;
        this.formNom = '';
        this.formPrenom = '';
      });
    } else {
      this.newFournisseur.nom = this.formNom;
      this.newFournisseur.prenom = this.formPrenom;
      this.fournisseurService.createFournisseur(this.newFournisseur).subscribe(() => {
        this.getAllFournisseurs();
        this.newFournisseur = { id_Four: 0, nom: '', prenom: '' };
        this.formNom = '';
        this.formPrenom = '';
      });
    }
  }

  deleteFournisseur(id: number): void {
    this.fournisseurService.deleteFournisseur(id).subscribe(() => {
      this.getAllFournisseurs();
    });
  }
}
