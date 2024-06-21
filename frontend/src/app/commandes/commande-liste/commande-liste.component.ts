import { Component } from '@angular/core';
import { Commande } from '../commande.model';
import { CommandeService } from '../commande.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-commande-liste',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './commande-liste.component.html',
  styleUrl: './commande-liste.component.css'
})
export class CommandeListeComponent {
  commandes: Commande[] = [];

constructor(private commandeService: CommandeService) { }
ngOnInit(): void {
  this.loadCommandes();
}

loadCommandes(): void {
  this.commandeService.getCommandes().subscribe(data => {
    this.commandes = data;
  });
}

addCommande(commande: Commande): void {
  this.commandeService.addCommande(commande).subscribe(() => {
    this.loadCommandes();
  });
}

updateCommande(commande: Commande): void {
  this.commandeService.updateCommande(commande).subscribe(() => {
    this.loadCommandes();
  });
}

deleteCommande(idCmd: number): void {
  this.commandeService.deleteCommande(idCmd).subscribe(() => {
    this.loadCommandes();
  });
}

}

