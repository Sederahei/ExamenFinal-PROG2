package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.ProcessusCorDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Processus_Cor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProcessusCorRepository implements ProcessusCorDAO {
    private final databaseConfig connection;

    public ProcessusCorRepository(databaseConfig connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterProcessusCor(Processus_Cor processusCor) throws SQLException {
        String query = "INSERT INTO processus_cor (date_debut, status, id_etudiant) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(processusCor.getDateDebut().getTime()));
            preparedStatement.setString(2, processusCor.getStatus());
            preparedStatement.setInt(3, processusCor.getIdEtudiant());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Processus_Cor obtenirProcessusCorParId(int id) throws SQLException {
        String query = "SELECT * FROM processus_cor WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Processus_Cor(
                        rs.getInt("id"),
                        rs.getDate("date_debut"),
                        rs.getString("status"),
                        rs.getInt("id_etudiant")
                );
            }
            return null;
        }
    }

    @Override
    public List<Processus_Cor> obtenirTousLesProcessusCor() throws SQLException {
        String query = "SELECT * FROM processus_cor";
        List<Processus_Cor> processusCors = new ArrayList<>();
        try (Statement statement = connection.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Processus_Cor processusCor = new Processus_Cor(
                        rs.getInt("id"),
                        rs.getDate("date_debut"),
                        rs.getString("status"),
                        rs.getInt("id_etudiant")
                );
                processusCors.add(processusCor);
            }
        }
        return processusCors;
    }

    @Override
    public void modifierProcessusCor(Processus_Cor processusCor) throws SQLException {
        String query = "UPDATE processus_cor SET date_debut=?, status=?, id_etudiant=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(processusCor.getDateDebut().getTime()));
            preparedStatement.setString(2, processusCor.getStatus());
            preparedStatement.setInt(3, processusCor.getIdEtudiant());
            preparedStatement.setInt(4, processusCor.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerProcessusCor(int id) throws SQLException {
        String query = "DELETE FROM processus_cor WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
