# 📱 Shop Manage App - Structure Complète du Projet

## 🎯 Vue d'ensemble

**Shop Manage App** est une application distribuée Java pour la gestion d'un réseau de boutiques et leurs produits. Elle suit une architecture modulaire avec une séparation claire entre :
- **Clients** (applications console)
- **Serveur** (API HTTP)
- **Modèles partagés** (données communes)

### Stack Technique
- **Langage** : Java 8+
- **Protocole** : HTTP (HttpServer)
- **Architecture** : Client-Serveur modulaire
- **Stockage** : En mémoire (extensible à BDD)

---

## 📂 Structure hiérarchique du projet

```
shop-manage-app/
├── README.md                          # Documentation principale
├── BOUTIQUE_README.md                 # Documentation module Boutique
├── test-final.bat                     # Script de test complet
├── run-boutique.bat                   # Lanceur Application Boutique
├── test-inputs*.txt                   # Fichiers de test interactifs
│
├── shared/                            # Module partagé (modèles)
│   └── src/
│       └── main/
│           └── java/
│               └── com/shopmanageapp/
│                   └── models/
│                       ├── Produit.java          # Modèle produit
│                       ├── Boutique.java         # Modèle boutique
│                       └── Role.java             # Modèle rôles (vide)
│
├── server/                            # Module serveur
│   └── src/
│       └── main/
│           └── java/
│               └── com/shopmanageapp/
│                   └── server/
│                       ├── ServerMain.java       # Point d'entrée serveur
│                       ├── HealthHandler.java    # Route /health
│                       └── RootHandler.java      # Route /
│
├── client-boutique/                   # Client Boutique (Console)
│   └── src/
│       └── main/
│           └── java/
│               └── com/shopmanageapp/
│                   ├── BoutiqueApp.java          # Application principale
│                   ├── GestionnaireProduits.java # Gestion produits
│                   └── TestBoutique.java         # Tests unitaires
│
└── client-user/                       # Client Utilisateur (Console)
    └── src/
        └── main/
            └── java/
                └── com/shopmanageapp/
                    ├── ClientApp.java            # Application principale
                    └── TestClient.java           # Tests unitaires
```

---

## 📦 Modules détaillés

### 1️⃣ Module `shared/` - Modèles partagés

Contient les classes métier utilisées par tous les modules.

#### **`Produit.java`**
```java
Attributs:
  - id: int                    // Identifiant unique
  - nom: String                // Nom du produit
  - categorie: String          // Catégorie (Informatique, Accessoires...)
  - description: String        // Description longue
  - prixUnitaire: double       // Prix en euros
  - imageUrl: String           // URL de l'image produit

Méthodes:
  + Produit()                  // Constructeur vide
  + Produit(nom, categorie, prix)  // Constructeur simplifié
  + getId/setId()
  + getNom/setNom()
  + getCategorie/setCategorie()
  + getDescription/setDescription()
  + getPrixUnitaire/setPrixUnitaire()
  + getImageUrl/setImageUrl()
  + toString()                 // Format: "nom (categorie) - prixUnitaire€"
```

#### **`Boutique.java`**
```java
Attributs:
  - id: int                    // Identifiant unique
  - nom: String                // Nom de la boutique
  - adresse: String            // Adresse physique
  - latitude: double           // Coordonnée GPS
  - longitude: double          // Coordonnée GPS
  - telephone: String          // Téléphone de contact
  - email: String              // Email de contact

Méthodes:
  + Boutique()                 // Constructeur vide
  + Boutique(nom, adresse, telephone)  // Constructeur simplifié
  + getId/setId()
  + getNom/setNom()
  + getAdresse/setAdresse()
  + getLatitude/setLatitude()
  + getLongitude/setLongitude()
  + getTelephone/setTelephone()
  + getEmail/setEmail()
  + toString()                 // Format: "nom - adresse"
```

#### **`Role.java`**
```
Fichier vide - Réservé pour implémentation future
Peut contenir: ADMIN, MANAGER, EMPLOYEE, CLIENT
```

---

### 2️⃣ Module `server/` - Serveur HTTP

Serveur léger utilisant `HttpServer` de Java (com.sun.net.httpserver).

**Point d'entrée** : `ServerMain.java`

#### **`ServerMain.java`**
```java
Attributs:
  - PORT = 8080                // Port d'écoute
  - server: HttpServer         // Instance serveur

Méthodes principales:
  + main(args)                 // Point d'entrée
  + start()                    // Démarre le serveur
  + configureRoutes()          // Configure les endpoints
  + stop()                     // Arrête le serveur

Routes configurées:
  - GET  /              → RootHandler
  - GET  /health        → HealthHandler
```

**URL d'accès** : `http://localhost:8080`

#### **`RootHandler.java`**
```
Endpoint: GET /

Retour HTTP:
  Status: 200 OK
  Content-Type: text/html
  Body: <html><body>
          <h1>Shop Manage App</h1>
          <p>Serveur en ligne</p>
          <p><a href='/health'>/health</a> - Test API</p>
        </body></html>
```

#### **`HealthHandler.java`**
```
Endpoint: GET /health

Retour HTTP:
  Status: 200 OK
  Content-Type: application/json
  Body: {
    "status": "OK",
    "message": "Serveur Shop Manage App en ligne"
  }

Headers CORS:
  Access-Control-Allow-Origin: *
```

---

### 3️⃣ Module `client-boutique/` - Application Boutique

Application console pour gérer les produits d'une boutique.

#### **`BoutiqueApp.java`** - Application principale
```java
Attributs:
  - gestionnaire: GestionnaireProduits  // Gestion des produits
  - scanner: Scanner                     // Lecture entrées utilisateur

Méthodes principales:
  + main(args)                 // Point d'entrée
  + afficherMenuPrincipal()    // Boucle menu interactif
  + ajouterProduit()           // Ajoute un produit
  + modifierProduit()          // Modifie un produit

Menu disponible:
  1. Voir mes produits         → Liste tous les produits
  2. Ajouter un produit        → Nouvelle saisie
  3. Modifier un produit       → Par ID
  4. Quitter                   → Ferme l'app
```

#### **`GestionnaireProduits.java`** - Gestionnaire de produits
```java
Attributs:
  - produits: List<Produit>    // ArrayList en mémoire
  - compteurId: int            // Incrémentation des IDs

Méthodes principales:
  + afficherTousProduits()     // Affiche la liste formatée
  + ajouterProduit(...)        // Ajoute produit en mémoire
  + modifierProduit(id, ...)   // Modifie un produit
  + obtenirProduit(id)         // Récupère un produit par ID
  + obtenirTousProduits()      // Retourne la liste complète

Données initiales (test):
  - ID 1: Laptop (Informatique) 899.99€
  - ID 2: Souris sans fil (Accessoires) 29.99€
  - ID 3: Clavier mécanique (Accessoires) 149.99€
```

#### **`TestBoutique.java`**
```
Fichier de tests unitaires - À développer
```

**Validations lors de l'ajout/modification** :
- ✅ Nom non vide
- ✅ Catégorie non vide
- ✅ Prix positif ou nul
- ✅ Format price en double
- ✅ ID produit valide (existence)

---

### 4️⃣ Module `client-user/` - Application Client Utilisateur

Application console pour les utilisateurs.

#### **`ClientApp.java`**
```
Point d'entrée pour les clients
À développer: gestion des comptes, commandes...
```

#### **`TestClient.java`**
```
Fichier de tests unitaires - À développer
```

---

## 🔄 Flux d'interaction

```
Utilisateur
    ↓
    ├─→ [client-boutique] BoutiqueApp
    │      ├─ Affiche Menu
    │      ├─ Lit Scanner
    │      └─ Appelle GestionnaireProduits
    │         └─ Gère List<Produit> en mémoire
    │
    ├─→ [client-user] ClientApp
    │      └─ À développer
    │
    └─→ [server] ServerMain (http://localhost:8080)
           ├─ GET / → RootHandler (HTML)
           └─ GET /health → HealthHandler (JSON)

[shared] Modèles
  ├─ Produit
  ├─ Boutique
  └─ Role
  └─ Utilisé par tous les modules
```

---

## 🚀 Points d'entrée du projet

| Module | Classe | Commande | Port/Interface |
|--------|--------|----------|-----------------|
| **Server** | `ServerMain` | `java -cp out/classes com.shopmanageapp.server.ServerMain` | `http://localhost:8080` |
| **Boutique** | `BoutiqueApp` | `java -cp out/classes com.shopmanageapp.BoutiqueApp` | Console (stdin) |
| **User** | `ClientApp` | `java -cp out/classes com.shopmanageapp.ClientApp` | Console (stdin) |

---

## 📋 Compilation

### Compilation complète
```powershell
$files = Get-ChildItem -Path "**/*.java" -Recurse | ForEach-Object { $_.FullName }
javac -d out/classes @files
```

### Compilation par module
```powershell
# Shared
javac -d out/classes shared/src/main/java/com/shopmanageapp/models/*.java

# Server
javac -d out/classes -cp out/classes server/src/main/java/com/shopmanageapp/server/*.java

# Client Boutique
javac -d out/classes -cp out/classes client-boutique/src/main/java/com/shopmanageapp/*.java

# Client User
javac -d out/classes -cp out/classes client-user/src/main/java/com/shopmanageapp/*.java
```

---

## 🧪 Tests et scripts

| Fichier | Description |
|---------|-------------|
| `test-final.bat` | Suite de tests complète du projet |
| `run-boutique.bat` | Lanceur automatique application Boutique |
| `test-inputs.txt` | Entrées test basiques (voir produits + ajouter) |
| `test-inputs-complet.txt` | Test complet (voir/ajouter/modifier) |
| `test-inputs-erreurs.txt` | Test gestion erreurs (options invalides, prix) |

---

## 🎓 Architecture et patterns utilisés

### Patterns
- **MVC léger** : BoutiqueApp (Vue/Contrôle) + GestionnaireProduits (Modèle)
- **Handler pattern** : HealthHandler, RootHandler
- **Singleton-like** : Un GestionnaireProduits par instance BoutiqueApp
- **Factory** : Constructeurs surchargés

### Principes
- ✅ **Séparation des responsabilités** : Modèles / Logique / Présentation
- ✅ **Réutilisabilité** : Module `shared/` pour les modèles
- ✅ **Extensibilité** : Structure préparée pour BDD, API REST, GUI
- ✅ **KISS** : Code simple et lisible (pas de frameworks externes)

---

## 🔮 Évolutions prévues

### Court terme
- [ ] Implémenter `TestBoutique.java` et `TestClient.java`
- [ ] Compléter `Role.java`
- [ ] Persistance fichier (JSON/CSV)
- [ ] Interface graphique (Swing/JavaFX)

### Moyen terme
- [ ] API REST complète (POST/PUT/DELETE)
- [ ] Base de données (PostgreSQL/MySQL)
- [ ] Authentification et autorisation
- [ ] Module gestion boutiques

### Long terme
- [ ] Microservices (Spring Boot)
- [ ] Frontend web (React/Vue)
- [ ] Mobile (Android)
- [ ] Docker & déploiement cloud

---

## 📝 Conventions de codage

### Packages
```
com.shopmanageapp              → Classes principales clients
com.shopmanageapp.server       → Classes serveur
com.shopmanageapp.models       → Modèles partagés
com.shopmanageapp.handlers     → Handlers HTTP (futur)
com.shopmanageapp.services     → Services métier (futur)
```

### Nommage
- **Classes** : PascalCase (`BoutiqueApp`, `GestionnaireProduits`)
- **Méthodes** : camelCase (`afficherMenu`, `ajouterProduit`)
- **Variables** : camelCase (`produits`, `scanner`)
- **Constantes** : UPPER_SNAKE_CASE (`PORT`, `MAX_SIZE`)

---

## 🛠️ Outils et dépendances

| Outil | Version | Usage |
|-------|---------|-------|
| **Java** | 8+ | Compilation et exécution |
| **JavaC** | 8+ | Compilateur |
| **HttpServer** | JDK (com.sun.net.httpserver) | Serveur HTTP intégré |
| **Scanner** | JDK java.util | Entrées console |
| **ArrayList** | JDK java.util | Stockage en mémoire |

**Aucune dépendance externe** - Utilise uniquement la JDK standard

---

## 📊 Statistiques du projet

| Métrique | Valeur |
|----------|--------|
| **Modules** | 4 (shared, server, client-boutique, client-user) |
| **Fichiers Java** | 11 |
| **Classes métier** | 2 (Produit, Boutique) |
| **Endpoints HTTP** | 2 (/, /health) |
| **Classes vides** | 3 (Role, TestBoutique, TestClient, ClientApp) |
| **Lignes de code** | ~500+ (sans les tests) |

---

## 📞 Support et documentation

- **README.md** - Vue d'ensemble générale
- **BOUTIQUE_README.md** - Documentation module Boutique
- **Ce fichier** - Structure détaillée du projet
- **Code** - Bien commenté avec Javadoc

@2250720337938
