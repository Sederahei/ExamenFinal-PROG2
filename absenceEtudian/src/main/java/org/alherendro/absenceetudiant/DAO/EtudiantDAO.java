package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.djbc.JDBCabsence;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.model.StatusEtudiant;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class EtudiantDAO {

    private Connection connection;

    public EtudiantDAO() {
        JDBCabsence jdbCabsence = new JDBCabsence();
        this.connection = jdbCabsence.getConnection();
    }

    public List<Etudiant> getAll() throws SQLException {
        String query = "SELECT * FROM etudiant";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        List<Etudiant> etudiants = new ArrayList<>();
        while (rs.next()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(rs.getInt("id"));
            etudiant.setNom(rs.getString("nom"));
            etudiant.setPrenom(rs.getString("prenom"));
            etudiant.setEmail(rs.getString("email"));
            etudiant.setAdress(rs.getString("adress"));
            etudiant.setStd(rs.getString("std"));
            etudiant.setStatus(StatusEtudiant.valueOf(rs.getString("status")));
            etudiants.add(etudiant);
        }
        return etudiants;
    }

    public Etudiant getById(int id) throws SQLException {
        String query = "SELECT * FROM etudiant WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(rs.getInt("id"));
            etudiant.setNom(rs.getString("nom"));
            etudiant.setPrenom(rs.getString("prenom"));
            etudiant.setEmail(rs.getString("email"));
            etudiant.setAdress(rs.getString("adress"));
            etudiant.setStd(
                    rs.getString("std"));
            etudiant.setStatus(StatusEtudiant.valueOf(rs.getString("status")));
            return etudiant;
        }
        return null;
    }

    public void create(Etudiant etudiant) throws SQLException {
        String query = "INSERT INTO etudiant (nom, prenom, email, adress, std, status) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, etudiant.getNom());
        preparedStatement.setString(2, etudiant.getPrenom());
        preparedStatement.setString(3, etudiant.getEmail());
        preparedStatement.setString(4, etudiant.getAdress());
        preparedStatement.setString(5, etudiant.getStd());
        preparedStatement.setString(6, etudiant.getStatus().name());
        preparedStatement.executeUpdate();
    }

    public void update(Etudiant etudiant) throws SQLException {
        String query = "UPDATE etudiant SET nom=?, prenom=?, email=?, adress=?, std=?, status=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, etudiant.getNom());
        preparedStatement.setString(2, etudiant.getPrenom());
        preparedStatement.setString(3, etudiant.getEmail());
        preparedStatement.setString(4, etudiant.getAdress());
        preparedStatement.setString(5, etudiant.getStd());
        preparedStatement.setString(6, etudiant.getStatus().name());
        preparedStatement.setInt(7, etudiant.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM etudiant WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public abstract void ajouterEtudiant(Etudiant etudiant);

    public abstract Etudiant obtenirEtudiantParId(int id);

    public abstract List<Etudiant> obtenirTousLesEtudiants();

    public abstract void modifierEtudiant(Etudiant etudiant);

    public abstract void supprimerEtudiant(int id);
}
