import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Produit } from './produit.model';
import { ProduitService } from './produit.service';

@Component({
  selector: 'app-produits',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css'
})
export class ProduitsComponent {

  produits: Produit[] = [];
  newProduit: Produit = {
    idProd: 0, nomProd: '', prix: 0, quantityStock: 0,
    fournisseurId: 0,
  };
  selectedProduit: Produit = {
    idProd: 0, nomProd: '', prix: 0, quantityStock: 0,
    fournisseurId: 0
  };
  editMode: boolean = false;

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.getAllProduits();
  }

  getAllProduits(): void {
    this.produitService.getAllProduits().subscribe(data => {
      this.produits = data;
    }, error => {
      console.error('Error fetching produits', error);
    });
  }
  createProduit(): void {
    this.produitService.createProduit(this.newProduit).subscribe((produit: Produit) => {
      this.produits.push(produit);
      this.newProduit = { idProd: 0, nomProd: '', prix: 0 , quantityStock: 0,
      fournisseurId: 0,}; // Reset form
    }, error => {
      console.error('Error creating produit', error);
    });
  }
  editProduit(produit: Produit): void {
    this.selectedProduit = { ...produit };
    this.editMode = true;
  }

  updateProduit(): void {
    this.produitService.updateProduit(this.selectedProduit.idProd, this.selectedProduit).subscribe(() => {
      this.getAllProduits(); // Refresh the list
      this.editMode = false; // Exit edit mode
    }, (error: any) => {
      console.error('Error updating produit', error);
    });
  }

  deleteProduit(id: number): void {
    this.produitService.deleteProduit(id).subscribe(() => {
      this.produits = this.produits.filter(produit => produit.idProd !== id);
    }, error => {
      console.error('Error deleting produit', error);
    });
  }
}

