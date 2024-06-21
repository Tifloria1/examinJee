import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', loadComponent: () => import('./home/home.component').then(m => m.HomeComponent) },
  { path: 'clients', loadComponent: () => import('./clients/liste/liste.component').then(m => m.ListeComponent) },
  { path: 'fournisseurs', loadComponent: () => import('./fournisseurs/fournisseurs.component').then(m => m.FournisseursComponent) },
  { path: 'produits', loadComponent: () => import('./produits/produits.component').then(m => m.ProduitsComponent) },
  { path: 'commandes', loadComponent: () => import('./commandes/commandes.component').then(m => m.CommandesComponent) },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home' }
];
