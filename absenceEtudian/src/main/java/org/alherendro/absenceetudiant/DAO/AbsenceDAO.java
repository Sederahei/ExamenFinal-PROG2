package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Absence;
import java.sql.SQLException;
import java.util.List;

public interface AbsenceDAO {
    void ajouterAbsence(Absence absence) throws SQLException;

    Absence obtenirAbsenceParId(int id) throws SQLException;

    List<Absence> obtenirToutesLesAbsences() throws SQLException;

    void modifierAbsence(Absence absence) throws SQLException;

    void supprimerAbsence(int id) throws SQLException;
}
