package org.example;

import io.javalin.Javalin;
import org.example.api.BoutiquesHandler;

public class App {
    public static void main(String[] args) {

        // Créer l'application Javalin et démarrer sur le port 8080
        Javalin app = Javalin.create().start(8080);

        // ---- Ton API ----
        app.get("/boutiques", BoutiquesHandler::getBoutiques);

        System.out.println(" Serveur démarré sur : http://localhost:8080");
        System.out.println(" Route disponible : GET http://localhost:8080/boutiques");
    }
}
