import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { FournisseurService } from '../fournisseur.service';
import { Router, RouterModule } from '@angular/router';
import { Fournisseur } from '../fournisseur.model';

@Component({
  selector: 'app-lfournisseur-list',
  standalone: true,
  imports: [
    NgFor,
    RouterModule

  ],
  templateUrl: './lfournisseur-list.component.html',
  styleUrl: './lfournisseur-list.component.css'
})
export class LfournisseurListComponent {
  fournisseurs: Fournisseur[] = []; // Initialize as an empty array
  fournisseur: any;
  constructor(private fournisseurService: FournisseurService, private router : Router){}

  

  ngOnInit() {
    this.loadFournisseurs(); // Assuming you have this method defined (see below)
  }
  
  loadFournisseurs(): void {
    this.fournisseurs = this.fournisseurService.getAllFournisseurs().subscribe((data: any) => {
      this.fournisseurs = data; // Assign the fetched data to fournisseurs
    });
  }

  deleteFournisseur(id: number): void {
    this.fournisseurService.deleteFournisseur(id).subscribe(() => {
      // This code will be executed when the deletion is successful (no value emitted)
      console.log("fournisseur est supprimer"); // Or perform other actions here
        this.loadFournisseurs(); // Refresh the list after successful deletion (optional)
    });
  }
}