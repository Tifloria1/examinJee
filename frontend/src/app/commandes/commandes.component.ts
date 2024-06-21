import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Commande } from './commande.model';
import { Client } from '../clients/client.model';
import { Produit } from '../produits/produit.model';
import { LigneCMD } from '../ligne-cmd/ligne-cmd.model';
import { ClientsService } from '../clients/clients.service';
import { ProduitService } from '../produits/produit.service';
import { CommandeService } from './commande.service';

@Component({
  selector: 'app-commandes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './commandes.component.html',
  styleUrl: './commandes.component.css'
})
export class CommandesComponent implements OnInit {
deleteCommande(arg0: number) {
throw new Error('Method not implemented.');
}
  commandes: Commande[] = [];
  clients: Client[] = [];
  products: Produit[] = [];
  selectedCommande: Commande | null = null;
  newCommande: Commande = { idCmd: 0, dateCmd: '', clientId: 0 };
  formClientId: number = 0;
  formDateCmd: string = '';
  lignesCmd: LigneCMD[] = [];
  newLigneCmd: LigneCMD = { idLigneCmd: 0, quantity: 0, produitId: 0, commandeId: 0 };
produit: any;

  constructor(
    private commandeService: CommandeService,
    private clientsService: ClientsService,
    private productsService: ProduitService
  ) {}

  ngOnInit(): void {
    this.getAllCommandes();
    this.getAllClients();
    this.getAllProducts();
  }

  getAllCommandes(): void {
    this.commandeService.getCommandes().subscribe((data: Commande[]) => {
      this.commandes = data;
    });
  }

  getAllClients(): void {
    this.clientsService.getAllClients().subscribe((data: Client[]) => {
      this.clients = data;
    });
  }

  getAllProducts(): void {
    this.productsService.getAllProduits().subscribe((data: Produit[]) => {
      this.products = data;
    });
  }

  selectCommande(commande: Commande): void {
    this.selectedCommande = { ...commande };
    this.formClientId = commande.clientId;
    this.formDateCmd = commande.dateCmd;
    this.getLignesCmd(commande.idCmd);
  }

  saveCommande(): void {
    if (this.selectedCommande) {
      this.selectedCommande.clientId = this.formClientId;
      this.selectedCommande.dateCmd = this.formDateCmd;
      this.commandeService.updateCommande(this.selectedCommande).subscribe(() => {
        this.getAllCommandes();
        this.selectedCommande = null;
        this.formClientId = 0;
        this.formDateCmd = '';
      });
    } else {
      this.newCommande.clientId = this.formClientId;
      this.newCommande.dateCmd = this.formDateCmd;
      this.commandeService.addCommande(this.newCommande).subscribe((commande: Commande | null) => {
        this.getAllCommandes();
        this.newCommande = { idCmd: 0, dateCmd: '', clientId: 0 };
        this.formClientId = 0;
        this.formDateCmd = '';
        this.selectedCommande = commande;
      });
    }
  }

  getLignesCmd(commandeId: number): void {
    this.commandeService.getLignesCmd(commandeId).subscribe((data: LigneCMD[]) => {
      this.lignesCmd = data;
    });
  }

  addLigneCmd(): void {
    if (this.selectedCommande) {
      this.newLigneCmd.commandeId = this.selectedCommande.idCmd;
      this.commandeService.addLigneCmd(this.selectedCommande.idCmd, this.newLigneCmd).subscribe(() => {
        this.getLignesCmd(this.selectedCommande!.idCmd);
        this.newLigneCmd = { idLigneCmd: 0, quantity: 0, produitId: 0, commandeId: 0 };
      });
    }
  }

  deleteLigneCmd(ligneCmdId: number): void {
    if (this.selectedCommande) {
      this.commandeService.deleteLigneCmd(this.selectedCommande.idCmd, ligneCmdId).subscribe(() => {
        this.getLignesCmd(this.selectedCommande!.idCmd);
      });
    }
  }
}

