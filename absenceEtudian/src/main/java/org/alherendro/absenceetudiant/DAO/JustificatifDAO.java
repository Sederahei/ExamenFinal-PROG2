package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Justificatif;

import java.sql.SQLException;
import java.util.List;

public interface JustificatifDAO {
    void ajouterJustificatif(Justificatif justificatif) throws SQLException;
    Justificatif obtenirJustificatifParId(int id) throws SQLException;
    List<Justificatif> obtenirTousLesJustificatifs() throws SQLException;
    void modifierJustificatif(Justificatif justificatif) throws SQLException;
    void supprimerJustificatif(int id) throws SQLException;
}
