        GESTION des Absences des Etudiants HEI


            GERER LES ABSENCE 
est un contrôleur Spring Boot REST qui gère les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer)
pour les absences d'étudiants dans l'application de gestion des absences. 
Ce contrôleur expose plusieurs endpoints pour interagir avec les absences en utilisant les services associés.

         les Endpoints
Ajouter une absence :

Méthode : POST
URL : /absences
Description : Ajoute une nouvelle absence à la base de données.

 exxemple :
 Body
Doit inclure un objet Absence en JSON avec les champs nécessaires (date_absence, cours, id_etudiant).
Retour :
Code HTTP 201 Created si l'absence est ajoutée avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Exemple de requête :

json
Copier le code
{
  "date_absence": "2024-09-22",
  "cours": "PROG1",
  "id_etudiant": 1
}
Obtenir une absence par ID :

Méthode : GET
URL : /absences/{id}
Description : Récupère les détails d'une absence spécifique par son identifiant.
Paramètre : id (identifiant de l'absence).
Retour :
Code HTTP 200 OK avec l'objet Absence si trouvé.
Code HTTP 404 Not Found si l'absence n'existe pas.
Code HTTP 500 Internal Server Error en cas d'erreur.
Obtenir toutes les absences :

Méthode : GET
URL : /absences
Description : Récupère la liste complète des absences.
Retour :
Code HTTP 200 OK avec la liste des absences.
Code HTTP 500 Internal Server Error en cas d'erreur.
Modifier une absence :

Méthode : PUT
URL : /absences/{id}
Description : Modifie les détails d'une absence existante.
Paramètre : id (identifiant de l'absence).
Body :
Doit inclure un objet Absence en JSON avec les informations modifiées.
Retour :
Code HTTP 200 OK si l'absence est modifiée avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Exemple de requête :

json
Copier le code
{
  "date_absence": "2024-09-22",
  "cours": "PROG1",
  "id_etudiant": 1
}
Supprimer une absence :

Méthode : DELETE
URL : /absences/{id}
Description : Supprime une absence par son identifiant.
Paramètre : id (identifiant de l'absence).
Retour :
Code HTTP 200 OK si l'absence est supprimée avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Gestion des erreurs
Si une erreur SQL survient lors de l'interaction avec la base de données, 
l'API renvoie un code HTTP 500 Internal Server Error pour informer l'utilisateur de l'échec de l'opération.
 Pour les Etudiante sont presque pareille 

                      POUR GERER LES ETUDIANTS 

 est un contrôleur Spring Boot REST qui gère les opérations CRUD 
(Créer, Lire, Mettre à jour, Supprimer) pour les entités Etudiant dans l'application de gestion des étudiants. 
Ce contrôleur expose plusieurs endpoints pour interagir avec les étudiants en utilisant les services associés.

Endpoints
Ajouter un étudiant :

Méthode : POST
URL : /etudiants
Description : Ajoute un nouvel étudiant à la base de données.
Body :
Doit inclure un objet Etudiant en JSON avec les informations comme nom, prenom, email, adress, std, et status.
Retour :
Code HTTP 201 Created si l'étudiant est ajouté avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Exemple de requête :

json
Copier le code
{
  "nom": "John",
  "prenom": "Doe",
  "email": "johndoe@example.com",
  "adress": "123 Main St",
  "std": "STD23001",
  "status": "ACTIF"
}
Obtenir un étudiant par ID :

Méthode : GET
URL : /etudiants/{id}
Description : Récupère les détails d'un étudiant spécifique par son identifiant.
Paramètre : id (identifiant de l'étudiant).
Retour :
Code HTTP 200 OK avec l'objet Etudiant si trouvé.
Code HTTP 404 Not Found si l'étudiant n'existe pas.
Code HTTP 500 Internal Server Error en cas d'erreur.
Obtenir tous les étudiants :

Méthode : GET
URL : /etudiants
Description : Récupère la liste complète des étudiants.
Retour :
Code HTTP 200 OK avec la liste des étudiants.
Code HTTP 500 Internal Server Error en cas d'erreur.
Modifier un étudiant :

Méthode : PUT
URL : /etudiants/{id}
Description : Modifie les informations d'un étudiant existant.
Paramètre : id (identifiant de l'étudiant).
Body :
Doit inclure un objet Etudiant en JSON avec les informations modifiées.
Retour :
Code HTTP 200 OK si l'étudiant est modifié avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Exemple de requête :

json
Copier le code
{
  "nom": "John",
  "prenom": "Smith",
  "email": "johnsmith@example.com",
  "adress": "456 Another St",
  "std": "STD23001",
  "status": "INACTIF"
}
Supprimer un étudiant :

Méthode : DELETE
URL : /etudiants/{id}
Description : Supprime un étudiant par son identifiant.
Paramètre : id (identifiant de l'étudiant).
Retour :
Code HTTP 200 OK si l'étudiant est supprimé avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Gestion des erreurs
Si une erreur SQL survient lors de l'interaction avec la base de données, l'API renvoie un code HTTP 500 Internal Server Error pour signaler l'échec de l'opération.EtudiantController
EtudiantController est un contrôleur Spring Boot REST qui gère les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) pour les entités Etudiant dans l'application de gestion des étudiants. Ce contrôleur expose plusieurs endpoints pour interagir avec les étudiants en utilisant les services associés.

            Endpoints
Ajouter un étudiant :

Méthode : POST
URL : /etudiants
Description : Ajoute un nouvel étudiant à la base de données.
Body :
Doit inclure un objet Etudiant en JSON avec les informations comme nom, prenom, email, adress, std, et status.
Retour :
Code HTTP 201 Created si l'étudiant est ajouté avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Exemple de requête :

json
Copier le code
{
  "nom": "John",
  "prenom": "Doe",
  "email": "johndoe@example.com",
  "adress": "123 Main St",
  "std": "STD23001",
  "status": "ACTIF"
}
Obtenir un étudiant par ID :

Méthode : GET
URL : /etudiants/{id}
Description : Récupère les détails d'un étudiant spécifique par son identifiant.
Paramètre : id (identifiant de l'étudiant).
Retour :
Code HTTP 200 OK avec l'objet Etudiant si trouvé.
Code HTTP 404 Not Found si l'étudiant n'existe pas.
Code HTTP 500 Internal Server Error en cas d'erreur.
Obtenir tous les étudiants :

Méthode : GET
URL : /etudiants
Description : Récupère la liste complète des étudiants.
Retour :
Code HTTP 200 OK avec la liste des étudiants.
Code HTTP 500 Internal Server Error en cas d'erreur.
Modifier un étudiant :

Méthode : PUT
URL : /etudiants/{id}
Description : Modifie les informations d'un étudiant existant.
Paramètre : id (identifiant de l'étudiant).
Body :
Doit inclure un objet Etudiant en JSON avec les informations modifiées.
Retour :
Code HTTP 200 OK si l'étudiant est modifié avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Exemple de requête :

json
Copier le code
{
  "nom": "John",
  "prenom": "Smith",
  "email": "johnsmith@example.com",
  "adress": "456 Another St",
  "std": "STD23001",
  "status": "INACTIF"
}
Supprimer un étudiant :

Méthode : DELETE
URL : /etudiants/{id}
Description : Supprime un étudiant par son identifiant.
Paramètre : id (identifiant de l'étudiant).
Retour :
Code HTTP 200 OK si l'étudiant est supprimé avec succès.
Code HTTP 500 Internal Server Error en cas d'erreur.
Gestion des erreurs
Si une erreur SQL survient lors de l'interaction avec la base de données, 
l'API renvoie un code HTTP 500 Internal Server Error pour signaler l'échec de l'opération .
