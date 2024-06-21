import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ClientsService } from '../clients.service';
import { Client } from '../client.model';

@Component({
  selector: 'app-liste',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.css']
})
export class ListeComponent implements OnInit {
  clients: Client[] = [];
  searchTerm: string = '';
  newClient: Client = { idClient: 0, nom: '', prenom: '' };
  selectedClient: Client = { idClient: 0, nom: '', prenom: '' };
  editMode: boolean = false;

  constructor(private clientsService: ClientsService) {}

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.clientsService.getAllClients().subscribe(data => {
      this.clients = data;
    });
  }

  searchClients(): void {
    if (this.searchTerm.trim()) {
      this.clientsService.searchClients(this.searchTerm).subscribe(data => {
        this.clients = data;
      });
    } else {
      this.loadClients();
    }
  }

  createClient(): void {
    this.clientsService.createClient(this.newClient).subscribe(client => {
      this.clients.push(client);
      this.newClient = { idClient: 0, nom: '', prenom: '' };
    });
  }

  editClient(client: Client): void {
    this.selectedClient = { ...client };
    this.editMode = true;
  }

  updateClient(): void {
    this.clientsService.updateClient(this.selectedClient.idClient, this.selectedClient).subscribe(() => {
      this.loadClients();
      this.editMode = false;
    });
  }

  deleteClient(id: number): void {
    this.clientsService.deleteClient(id).subscribe(() => {
      this.clients = this.clients.filter(client => client.idClient !== id);
    });
  }
}
