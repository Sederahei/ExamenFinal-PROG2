package org.alherendro.absenceetudiant.repository;
import org.alherendro.absenceetudiant.entite.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class EtudiantRepository {

        private static final String URL = "jdbc:postgresql://localhost:5432/absence";
        private static final String USER = "postgresql";
        private static final String PASSWORD = "alherendro";



        // Connexion à la base de données
        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        // Méthode pour récupérer tous les étudiants
        public List<Etudiant> findAll() throws SQLException {
            List<Etudiant> etudiants = new ArrayList<>();
            String query = "SELECT * FROM etudiant";

            try (Connection conn = getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    Etudiant etudiant = new Etudiant(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("adress"),
                            rs.getString("STD"),
                            rs.getString("status")
                    );
                    etudiants.add(etudiant);
                }
            }
            return etudiants;
        }

        // Méthode pour insérer un étudiant
        public void obtenirEtudiant (Etudiant etudiant) throws SQLException {
            String query = "INSERT INTO etudiant (nom, prenom, email, adress, STD) VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, etudiant.getNom());
                stmt.setString(2, etudiant.getPrenom());
                stmt.setString(3, etudiant.getEmail());
                stmt.setString(4, etudiant.getAdresse());
                stmt.setString(5, etudiant.getStd());
                stmt.setString(6, String.valueOf(etudiant.getStatus()));

                stmt.executeUpdate();
            }
        }
    }


