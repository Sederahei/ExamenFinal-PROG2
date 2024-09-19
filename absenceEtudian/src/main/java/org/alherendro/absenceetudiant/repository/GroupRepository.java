package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.GroupDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository implements GroupDAO {

    private final Connection connection;

    @Autowired
    public GroupRepository(databaseConfig databaseConfig) throws SQLException {
        this.connection = databaseConfig.getConnection();
    }

    @Override
    public void ajouterGroup(Group group) throws SQLException {
        String query = "INSERT INTO \"group\" (nom) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, group.getNom());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Group obtenirGroupParId(int id) throws SQLException {
        String query = "SELECT * FROM \"group\" WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Group(
                        rs.getInt("id"),
                        rs.getString("nom")
                );
            }
            return null;
        }
    }

    @Override
    public List<Group> obtenirTousLesGroupes() throws SQLException {
        String query = "SELECT * FROM \"group\"";
        List<Group> groups = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Group group = new Group(
                        rs.getInt("id"),
                        rs.getString("nom")
                );
                groups.add(group);
            }
        }
        return groups;
    }

    @Override
    public void modifierGroup(Group group) throws SQLException {
        String query = "UPDATE \"group\" SET nom=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, group.getNom());
            preparedStatement.setInt(2, group.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerGroup(int id) throws SQLException {
        String query = "DELETE FROM \"group\" WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
