package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.StatusEtudiantDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Status_etudiant;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusEtudiantRepository implements StatusEtudiantDAO {

    private final Connection connection;

    public StatusEtudiantRepository(databaseConfig connection) throws SQLException {
        this.connection = connection.getConnection();
    }

    @Override
    public void ajouterStatusEtudiant(Status_etudiant statusEtudiant) throws SQLException {
        String query = "INSERT INTO status_etudiant (status) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, statusEtudiant.getStatus());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Status_etudiant obtenirStatusEtudiantParId(int id) throws SQLException {
        String query = "SELECT * FROM status_etudiant WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Status_etudiant(
                        rs.getInt("id"),
                        rs.getString("status")
                );
            }
            return null;
        }
    }

    @Override
    public List<Status_etudiant> obtenirTousLesStatusEtudiants() throws SQLException {
        String query = "SELECT * FROM status_etudiant";
        List<Status_etudiant> statusEtudiants = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Status_etudiant statusEtudiant = new Status_etudiant(
                        rs.getInt("id"),
                        rs.getString("status")
                );
                statusEtudiants.add(statusEtudiant);
            }
        }
        return statusEtudiants;
    }

    @Override
    public void modifierStatusEtudiant(Status_etudiant statusEtudiant) throws SQLException {
        String query = "UPDATE status_etudiant SET status=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, statusEtudiant.getStatus());
            preparedStatement.setInt(2, statusEtudiant.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerStatusEtudiant(int id) throws SQLException {
        String query = "DELETE FROM status_etudiant WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
