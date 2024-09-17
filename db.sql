CREATE DATABASE absence;

\c absence

CREATE TABLE etudiant (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(150) NOT NULL,
    prenom VARCHAR(120) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    adress VARCHAR(150),
    STD VARCHAR(10) NOT NULL
);

CREATE TABLE niveau (
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL
);

CREATE TABLE absence (
    id SERIAL PRIMARY KEY,
    date_absence DATE NOT NULL,
    cours VARCHAR(120),
    id_etudiant INT NOT NULL,
    FOREIGN KEY (id_etudiant) REFERENCES etudiant(id) ON DELETE CASCADE
);

CREATE TABLE justificatif (
    id SERIAL PRIMARY KEY,
    dat_justificative DATE NOT NULL,
    cours VARCHAR(120),
    status_justicative VARCHAR(120) NOT NULL,
    id_absence INT,
    FOREIGN KEY (id_absence) REFERENCES absence(id) ON DELETE CASCADE
);

CREATE TABLE processus_COR (
    id SERIAL PRIMARY KEY,
    date_debut DATE NOT NULL,
    status VARCHAR(120) NOT NULL,
    id_etudiant INT,
    FOREIGN KEY (id_etudiant) REFERENCES etudiant(id) ON DELETE CASCADE
);

CREATE TABLE "group" (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(120) NOT NULL
);

CREATE TABLE status_etudiant (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL
);

\d etudiant;
ALTER TABLE etudiant ADD COLUMN status VARCHAR(50) NOT NULL DEFAULT 'ACTIF';

