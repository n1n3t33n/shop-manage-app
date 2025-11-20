package org.example.api;

import io.javalin.http.Context;

public class BoutiquesHandler {

    public static void getBoutiques(Context ctx) {
        String json = """
                [
                    {"id": 1, "nom": "Boutique A", "ville": "Abidjan"},
                    {"id": 2, "nom": "Boutique B", "ville": "Bouaké"},
                    {"id": 3, "nom": "Boutique C", "ville": "Yamoussoukro"}
                    {"id": 4, "nom": "Boutique D", "ville": "Grand-Bassam"}
                ]
                """;

        ctx.contentType("application/json");
        ctx.result(json);
    }
}
