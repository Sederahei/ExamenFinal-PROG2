package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.EtudiantDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.model.StatusEtudiant;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EtudiantRepository implements EtudiantDAO {

    private final Connection connection;

    public EtudiantRepository(databaseConfig config) throws SQLException {
        this.connection = config.getConnection();
    }

    @Override
    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        String query = "INSERT INTO etudiant (nom, prenom, email, adress, std, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setString(4, etudiant.getAdress());
            preparedStatement.setString(5, etudiant.getStd());
            preparedStatement.setString(6, etudiant.getStatus().name());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Etudiant obtenirEtudiantParId(int id) throws SQLException {
        String query = "SELECT * FROM etudiant WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("adress"),
                        rs.getString("std"),
                        rs.getString("status")
                );
            }
            return null;
        }
    }

    @Override
    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {
        String query = "SELECT * FROM etudiant";
        List<Etudiant> etudiants = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("adress"),
                        rs.getString("std"),
                        rs.getString("status")
                );
                etudiants.add(etudiant);
            }
        }
        return etudiants;
    }

    @Override
    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        String query = "UPDATE etudiant SET nom=?, prenom=?, email=?, adress=?, std=?, status=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setString(4, etudiant.getAdress());
            preparedStatement.setString(5, etudiant.getStd());
            preparedStatement.setString(6, etudiant.getStatus().name());
            preparedStatement.setInt(7, etudiant.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerEtudiant(int id) throws SQLException {
        String query = "DELETE FROM etudiant WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
