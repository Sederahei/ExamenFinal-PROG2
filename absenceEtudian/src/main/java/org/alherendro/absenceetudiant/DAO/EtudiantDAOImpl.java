package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.djbc.JDBCabsence;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class EtudiantDAOImpl extends EtudiantDAO {
        private Connection connection;

        public EtudiantDAOImpl() {
            super();
            JDBCabsence jdbCabsence = new JDBCabsence();
            this.connection = jdbCabsence.getConnection();
        }

        @Override
        public void ajouterEtudiant(Etudiant etudiant) {
            String query = "INSERT INTO etudiant (nom, prenom, email, adress, STD) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, etudiant.getNom());
                statement.setString(2, etudiant.getPrenom());
                statement.setString(3, etudiant.getEmail());
                statement.setString(4, etudiant.getAdress());
                statement.setString(5, etudiant.getStd());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Etudiant obtenirEtudiantParId(int id) {
            // Code pour obtenir un étudiant par ID
            return null;
        }

        @Override
        public List<Etudiant> obtenirTousLesEtudiants() {
            // Code pour obtenir tous les étudiants
            return List.of();
        }

        @Override
        public void modifierEtudiant(Etudiant etudiant) {
            // Code pour modifier un étudiant
        }

        @Override
        public void supprimerEtudiant(int id) {
            // Code pour supprimer un étudiant
        }
    }

