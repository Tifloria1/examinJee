import { Component, OnInit } from '@angular/core';
import { Produit } from '../produit.model';
import { ProduitService } from '../produit.service';
import { CommonModule, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-produit-list',
  standalone: true,
  imports: [
    NgFor,
    FormsModule, // Include FormsModule here
    RouterModule,
    CommonModule   
  ],
  templateUrl: './produit-list.component.html',
  styleUrl: './produit-list.component.css'
})
export class ProduitListComponent implements OnInit{
  produits: Produit[] = [];
  newProduit: Produit = {} as Produit;

  constructor(private produitService: ProduitService, ){}

  ngOnInit() {
    this.loadProduits(); // Assuming you have this method defined (see below)
  }

  loadProduits(): void {
    this.produitService.getAllProduits().subscribe(data => {
      this.produits = data;
    });
  }

  addProduit(): void {
    this.produitService.addProduit(this.newProduit).subscribe(() => {
      this.loadProduits();
      this.newProduit = {} as Produit; // Reset form after submission

    });

  }

  updateProduit(produit: Produit): void {
    this.produitService.updateProduit(produit).subscribe(() => {
      this.loadProduits();
    });
  }

  deleteProduit(idProd: number): void {
    this.produitService.deleteProduit(idProd).subscribe(() => {
      this.loadProduits();
    });
  }


  }
