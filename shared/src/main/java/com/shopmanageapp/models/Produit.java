package com.shopmanageapp.models;

/**
 * Classe représentant un produit
 */
public class Produit {
    private int id;
    private String nom;
    private String categorie;
    private String description;
    private double prixUnitaire;
    private String imageUrl;
    
    // Constructeurs
    public Produit() {}
    
    public Produit(String nom, String categorie, double prixUnitaire) {
        this.nom = nom;
        this.categorie = categorie;
        this.prixUnitaire = prixUnitaire;
    }
    
    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    @Override
    public String toString() {
        return nom + " (" + categorie + ") - " + prixUnitaire + "€";
    }
}