package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.JustificatifDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Justificatif;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JustificatifRepository implements JustificatifDAO {

    private final Connection connection;

    public JustificatifRepository(databaseConfig dbConfig) throws SQLException {
        this.connection = dbConfig.getConnection();
    }

    @Override
    public void ajouterJustificatif(Justificatif justificatif) throws SQLException {
        String query = "INSERT INTO justificatif (dat_justificative, cours, status_justicative, id_absence) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(justificatif.getDateJustificative().getTime()));
            preparedStatement.setString(2, justificatif.getCours());
            preparedStatement.setString(3, justificatif.getStatusJustificative());
            preparedStatement.setInt(4, justificatif.getIdAbsence());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Justificatif obtenirJustificatifParId(int id) throws SQLException {
        String query = "SELECT * FROM justificatif WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Justificatif(
                        rs.getInt("id"),
                        rs.getDate("dat_justificative"),
                        rs.getString("cours"),
                        rs.getString("status_justicative"),
                        rs.getInt("id_absence")
                );
            }
            return null;
        }
    }

    @Override
    public List<Justificatif> obtenirTousLesJustificatifs() throws SQLException {
        String query = "SELECT * FROM justificatif";
        List<Justificatif> justificatifs = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Justificatif justificatif = new Justificatif(
                        rs.getInt("id"),
                        rs.getDate("dat_justificative"),
                        rs.getString("cours"),
                        rs.getString("status_justicative"),
                        rs.getInt("id_absence")
                );
                justificatifs.add(justificatif);
            }
        }
        return justificatifs;
    }

    @Override
    public void modifierJustificatif(Justificatif justificatif) throws SQLException {
        String query = "UPDATE justificatif SET dat_justificative=?, cours=?, status_justicative=?, id_absence=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(justificatif.getDateJustificative().getTime()));
            preparedStatement.setString(2, justificatif.getCours());
            preparedStatement.setString(3, justificatif.getStatusJustificative());
            preparedStatement.setInt(4, justificatif.getIdAbsence());
            preparedStatement.setInt(5, justificatif.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerJustificatif(int id) throws SQLException {
        String query = "DELETE FROM justificatif WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
