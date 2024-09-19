package org.alherendro.absenceetudiant.repository;

import org.alherendro.absenceetudiant.DAO.AbsenceDAO;
import org.alherendro.absenceetudiant.databaseConnection.databaseConfig;
import org.alherendro.absenceetudiant.entite.Absence;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AbsenceRepository implements AbsenceDAO {

    private final Connection connection;

    public AbsenceRepository(databaseConfig databaseConfig) throws SQLException {
        this.connection = databaseConfig.getConnection();
    }

    @Override
    public void ajouterAbsence(Absence absence) throws SQLException {
        String query = "INSERT INTO absence (date_absence, cours, id_etudiant) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(absence.getDateAbsence().getTime()));
            preparedStatement.setString(2, absence.getCours());
            preparedStatement.setInt(3, absence.getIdEtudiant());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Absence obtenirAbsenceParId(int id) throws SQLException {
        String query = "SELECT * FROM absence WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Absence(
                        rs.getInt("id"),
                        rs.getDate("date_absence"),
                        rs.getString("cours"),
                        rs.getInt("id_etudiant")
                );
            }
            return null;
        }
    }

    @Override
    public List<Absence> obtenirToutesLesAbsences() throws SQLException {
        String query = "SELECT * FROM absence";
        List<Absence> absences = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Absence absence = new Absence(
                        rs.getInt("id"),
                        rs.getDate("date_absence"),
                        rs.getString("cours"),
                        rs.getInt("id_etudiant")
                );
                absences.add(absence);
            }
        }
        return absences;
    }

    @Override
    public void modifierAbsence(Absence absence) throws SQLException {
        String query = "UPDATE absence SET date_absence=?, cours=?, id_etudiant=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(absence.getDateAbsence().getTime()));
            preparedStatement.setString(2, absence.getCours());
            preparedStatement.setInt(3, absence.getIdEtudiant());
            preparedStatement.setInt(4, absence.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void supprimerAbsence(int id) throws SQLException {
        String query = "DELETE FROM absence WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
