package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.NiveauDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Niveau;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NiveauRepository implements NiveauDAO {

    private final databaseConfig connection;

    public NiveauRepository(databaseConfig connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterNiveau(Niveau niveau) throws SQLException {
        String query = "INSERT INTO niveau (name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, niveau.getName());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Niveau obtenirNiveauParId(int id) throws SQLException {
        String query = "SELECT * FROM niveau WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Niveau(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
            return null;
        }
    }

    @Override
    public List<Niveau> obtenirTousLesNiveaux() throws SQLException {
        String query = "SELECT * FROM niveau";
        List<Niveau> niveaux = new ArrayList<>();
        try (Statement statement = connection.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Niveau niveau = new Niveau(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                niveaux.add(niveau);
            }
        }
        return niveaux;
    }

    @Override
    public void modifierNiveau(Niveau niveau) throws SQLException {
        String query = "UPDATE niveau SET name=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, niveau.getName());
            preparedStatement.setInt(2, niveau.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerNiveau(int id) throws SQLException {
        String query = "DELETE FROM niveau WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
