package com.shopmanageapp.server;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerMain {
    private static final int PORT = 8080;
    private HttpServer server;
    
    public static void main(String[] args) {
        System.out.println("Demarrage du serveur Shop Manage App...");
        new ServerMain().start();
    }
    
    public void start() {
        try {
            server = HttpServer.create(new InetSocketAddress(PORT), 0);
            configureRoutes();
            server.start();
            System.out.println("Serveur demarre sur le port " + PORT);
            System.out.println("URL: http://localhost:" + PORT);
        } catch (IOException e) {
            System.err.println("Erreur demarrage serveur: " + e.getMessage());
        }
    }
    
    private void configureRoutes() {
        // AJOUTER CETTE LIGNE POUR LA RACINE /
        server.createContext("/", new RootHandler());
        
        // Route de santé
        server.createContext("/health", new HealthHandler());
    }
    
    public void stop() {
        if (server != null) {
            server.stop(0);
            System.out.println("Serveur arrete");
        }
    }
}