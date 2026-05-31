# 🎮 GameStore

GameStore est une application web de gestion d'un catalogue de jeux vidéo. Elle permet de lister des jeux vidéo en liant des informations telles que le titre, la plateforme, l'année de sortie, la catégorie et le prix.

Ce projet est développé en Java avec le framework **Spring Boot** pour le backend, et utilise **Thymeleaf**, **Tailwind CSS (v4)** et **Flowbite** pour une interface utilisateur moderne et réactive.

## 🛠️ Stack Technique

### Backend (Java 21)
* **Spring Boot (v4.0.x)** : Framework principal de l'application.
* **Spring Data JPA / Hibernate** : ORM pour la gestion de la persistance des données.
* **Spring Web MVC** : Pour la création des contrôleurs REST et MVC.
* **PostgreSQL** : Système de gestion de base de données relationnelle.
* **Lombok** : Pour réduire le code boilerplate (Getters, Setters, Constructeurs).
* **Jakarta Validation** : Pour la validation robuste des modèles de données.
* **SimpleFlatMapper (SFM)** : Utilisé pour le mapping performant des requêtes JDBC personnalisées.

### Frontend
* **Thymeleaf** : Moteur de templates côté serveur pour le rendu HTML dynamique.
* **Tailwind CSS (v4)** : Framework CSS utilitaire paramétré nativement en CSS (`@theme`).
* **Flowbite** : Bibliothèque de composants UI basés sur Tailwind CSS.

## ⚙️ Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé les éléments suivants sur votre machine :
- [Java Development Kit (JDK) 21](https://jdk.java.net/21/)
- [Maven](https://maven.apache.org/) (optionnel, le wrapper `mvnw` est inclus)
- [PostgreSQL](https://www.postgresql.org/) (Généralement écoutant sur le port `5432`)
- [Node.js & npm](https://nodejs.org/) (Uniquement si vous souhaitez recompiler le CSS Tailwind)

## 🚀 Installation & Lancement

### 1. Configuration de la base de données
Connectez-vous à votre serveur PostgreSQL et créez une base de données nommée `game_store` :
```sql
CREATE DATABASE game_store;
```

### 2. Cloner et préparer le projet
```bash
git clone <url-de-votre-depot>
cd gamestore
```
### 3. (Optionnel) Compiler le CSS Tailwind
Si vous souhaitez personnaliser le CSS Tailwind, vous pouvez recompiler les styles :
```bash
npm install
npx @tailwindcss/cli -i ./src/main/resources/static/css/input.css -o ./src/main/resources/static/css/app.css --watch
```

L'application sera accessible depuis votre navigateur à l'adresse htp://localhost:8081.

(Note : Au premier lancement, Hibernate génèrera automatiquement la structure des tables SQL si la propriété spring.jpa.hibernate.ddl-auto est correctement configurée).
### 🏗️ Structure fonctionnelle (Modèle)
L'entité principale est le VideoGame. Ses propriétés incluent :
- id (Long, Clé primaire générée)
- title (String, Non nul, max 100 caractères)
- plateform (Enum : PC, PLAYSTATION_5, NINTENDO_SWITCH, etc.)
- category (Enum : RPG, ACTION, ADVENTURE, etc.)
- releaseYear (Int, entre 1950 et 2100)
- price (Double, Positif ou zéro)
### 💡 Remarques
Le projet intègre un JdbcClient personnalisé via un ResultSetExtractorImpl alimenté par SimpleFlatMapper pour optimiser la fonction de recherche par mots-clés (getGame).
Le Dark Mode Tailwind est supporté de manière native.