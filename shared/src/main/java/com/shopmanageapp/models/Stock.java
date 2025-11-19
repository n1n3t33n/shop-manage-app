package com.shopmanageapp.models;

/**
 * Classe qui représente le stock d'un produit dans une boutique
 * Exemple : "Boutique A a 10 croissants à 1.50€"
 */
public class Stock {
    private int boutiqueId;    // ID de la boutique
    private int produitId;     // ID du produit  
    private int quantite;      // Nombre en stock (ex: 10)
    private double prix;       // Prix dans cette boutique (ex: 1.50)
    
    // Constructeur vide (obligatoire)
    public Stock() {}
    
    // Constructeur avec paramètres
    public Stock(int boutiqueId, int produitId, int quantite, double prix) {
        this.boutiqueId = boutiqueId;
        this.produitId = produitId;
        this.quantite = quantite;
        this.prix = prix;
    }
    
    // GETTERS ET SETTERS (copiés de Boutique.java et adaptés)
    
    public int getBoutiqueId() { 
        return boutiqueId; 
    }
    
    public void setBoutiqueId(int boutiqueId) { 
        this.boutiqueId = boutiqueId; 
    }
    
    public int getProduitId() { 
        return produitId; 
    }
    
    public void setProduitId(int produitId) { 
        this.produitId = produitId; 
    }
    
    public int getQuantite() { 
        return quantite; 
    }
    
    public void setQuantite(int quantite) { 
        this.quantite = quantite; 
    }
    
    public double getPrix() { 
        return prix; 
    }
    
    public void setPrix(double prix) { 
        this.prix = prix; 
    }
    
    // Méthode pour afficher l'objet
    @Override
    public String toString() {
        return "Stock [boutiqueId=" + boutiqueId + ", produitId=" + produitId + 
               ", quantite=" + quantite + ", prix=" + prix + "]";
    }
}