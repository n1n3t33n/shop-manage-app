package com.shopmanageapp;

import java.util.Scanner;

public class ClientConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue sur ShopManage !");
        System.out.println("Quel produit cherchez-vous ?");

        String produit = scanner.nextLine();

        System.out.println("Résultats de recherche pour : " + produit);
        System.out.println("----------------------------");
        System.out.println("1. " + produit + " - Prix : 10 000 FCFA");
        System.out.println("2. " + produit + " Deluxe - Prix : 15 000 FCFA");
        System.out.println("3. " + produit + " Premium - Prix : 20 000 FCFA");
        System.out.println("----------------------------");
        System.out.println("Merci d'avoir utilisé ShopManage !");

        scanner.close();
    }
}
