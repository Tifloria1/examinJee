import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { routes } from './app.routes';
import { ListeComponent } from './clients/liste/liste.component';
import { FournisseursComponent } from './fournisseurs/fournisseurs.component';
import { ProduitsComponent } from './produits/produits.component';
import { CommandesComponent } from './commandes/commandes.component';

@NgModule({
 
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: []
})
export class AppModule { }
